package org.springframework.samples.petclinic.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = {"org.springframework.samples.petclinic.owner","org.springframework.samples.petclinic.vet"},
    importOptions = ImportOption.DoNotIncludeTests.class)
public class ControllerRepositoryArchTest {

    @ArchTest
    ArchRule relation = classes()
        .that().haveNameMatching(".*Controller")
        .should().accessClassesThat().haveNameMatching(".*Repository");

    @ArchTest
    ArchRule controllerAnnotation = classes()
        .that().haveNameMatching(".*Controller")
        .should().beAnnotatedWith("org.springframework.stereotype.Controller");

    @ArchTest
    ArchRule repositoryDefinition = classes()
        .that().haveNameMatching(".*Repository")
        .should().beAnnotatedWith("org.springframework.stereotype.Repository")
        .orShould().beAssignableTo("org.springframework.data.repository.Repository");
}
