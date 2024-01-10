package br.com.fsales.nexstream.architecture;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "br.com.fsales.nexstream", importOptions = ImportOption.DoNotIncludeTests.class)
public class LayeredArchitectureTest {

    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture().consideringAllDependencies()
            .layer(
                    "Controllers"
            ).definedBy(
                    "br.com.fsales.nexstream.presentation.."
            )
            .layer(
                    "UseCase"
            ).definedBy("br.com.fsales.nexstream.usecase..")
            .layer(
                    "Infrastucture"
            ).definedBy(
                    "br.com.fsales.nexstream.infrastructure.."
            )
            .whereLayer(
                    "Controllers"
            ).mayNotBeAccessedByAnyLayer()
            .whereLayer(
                    "UseCase"
            )
            .mayOnlyBeAccessedByLayers(
                    "Controllers"
            )
            .whereLayer(
                    "Infrastucture"
            ).mayNotBeAccessedByAnyLayer();
}
