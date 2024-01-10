package br.com.fsales.nexstream.domain.core.video.model;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import br.com.fsales.nexstream.builders.VideoBuilders;
import br.com.fsales.nexstream.domain.RegraDeNegocioException;
import br.com.fsales.nexstream.domain.core.video.dto.DadosCadastrarVideoDto;
import br.com.fsales.nexstream.domain.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.usecase.video.dto.DadosVideoResponse;
import br.com.fsales.nexstream.usecase.video.impl.CadastrarVideoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class VideoServiceTest {

    @InjectMocks
    private CadastrarVideoService service;

    @Mock
    private VideoRepository repository;

    @Mock
    private DadosCadastrarVideoDto dados;

    private Video video;

    private DadosVideoResponse dadosVideoResponse;

    @BeforeEach
    void setup() {
        this.video = VideoBuilders.build(
                UUID.randomUUID().toString(),
                "Oppenheimer",
                """
                        O filme é um show visual e auditivo, muito acima da média. A trilha sonora eleva bastante a experiência, 
                        tornando-o extremamente imersivo. A tensão é constante, e há poucos momentos de respiro para conseguirmos absorver tudo. No entanto,
                        Nolan consegue dosar bem para não causar uma exaustão tão grande. As atuações são ótimas, com Cillian Murphy e Robert Downey Jr. se destacando bastante. 
                        É uma pena que Florence Pugh tenha sido pouco aproveitada. Outro problema é a confusão temporal, já que o filme não consegue situar claramente o espectador no tempo, causando um pouco de confusão.                        
                        Mas, no geral, é um filme incrível, imersivo e tenso, sendo um dos melhores trabalhos de Christopher Nolan. Aborda de forma brilhante um contexto histórico muito importante, 
                        condenando todos os lados envolvidos e proporcionando uma experiência cinematográfica perfeita nos quesitos técnicos, mas que também se destaca muito em sua história envolvente, tensa e impactante.
                        """,
                "https://youtu.be/ILAwV65XuGA");
        this.dadosVideoResponse = new DadosVideoResponse(video);
        lenient().when(dados.titulo()).thenReturn(video.getTitulo());
        lenient().when(dados.descricao()).thenReturn(video.getDescricao());
        lenient().when(dados.url()).thenReturn(video.getUrl());
    }

    @Nested
    class CadastrarVideo {
        @Test
        @DisplayName("Deve Cadastrar um Vídeo")
        void deveCadastrarUmVideo() {

            // Mock do comportamento do repository
            when(repository.cadastrar(Mockito.any(Video.class))).thenReturn(Mono.just(video));

            // Chame o método save e verifique o resultado
            StepVerifier.create(service.execute(dados))
                    .expectNext(dadosVideoResponse)
                    .verifyComplete();

            // Verificar que o método foi chamado pelo menos uma vez
            verify(repository, atLeastOnce()).cadastrar(any(Video.class));

        }

        @Test
        @DisplayName("Não Deve Cadastrar um Vídeo com o mesmo título")
        void naoDeveCadastrarUmVideoComOMesmoTitulo() {
            // Mock do comportamento do repository
            when(repository.tituloJaCadastrado(any(String.class))).thenReturn(Mono.just(Boolean.TRUE));

            // Chame o método execute e verifique se a exceção é lançada corretamente
            StepVerifier.create(service.execute(dados))
                    .expectError(RegraDeNegocioException.class)
                    .verify();

            // Verificar que o método cadastrar não foi chamado
            verify(repository, never()).cadastrar(any(Video.class));
        }

        @Test
        @DisplayName("Não Deve Cadastrar um Vídeo com Dados Inválidos")
        void naoDeveCadastrarUmVideoComDadosInvalidos() {
            // Configurar dados inválidos
            when(dados.titulo()).thenReturn(null);

            // Chame o método execute e verifique se a exceção é lançada corretamente
            StepVerifier.create(service.execute(dados))
                    .expectErrorMatches(throwable ->
                            throwable instanceof RegraDeNegocioException &&
                            throwable.getMessage().contains("Todos os campos do vídeo são obrigatórios."))
                    .verify();

            // Verificar que o método cadastrar não foi chamado
            verify(repository, never()).cadastrar(any(Video.class));
        }


    }


}