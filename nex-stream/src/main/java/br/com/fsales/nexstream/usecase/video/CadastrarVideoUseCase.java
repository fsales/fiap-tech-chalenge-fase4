package br.com.fsales.nexstream.usecase.video;

import br.com.fsales.nexstream.domain.core.video.dto.DadosCadastrarVideoDto;
import br.com.fsales.nexstream.usecase.video.dto.DadosVideoResponse;
import reactor.core.publisher.Mono;

public interface CadastrarVideoUseCase {
    Mono<DadosVideoResponse> execute(DadosCadastrarVideoDto dados);
}
