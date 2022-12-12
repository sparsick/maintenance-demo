package org.springframework.samples.petclinic.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.freeze.FreezingArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(importOptions = ImportOption.DoNotIncludeTests.class)
public class ControllerRepositoryFreezeArchTest {

    @ArchTest
    ArchRule relation = FreezingArchRule.freeze(classes()
        .that().haveNameMatching(".*Repository")
        .should().onlyBeAccessed().byClassesThat().haveNameMatching(".*Controller"));
}
