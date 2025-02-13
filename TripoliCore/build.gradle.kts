/*
 * Copyright 2022 James Bowring, Noah McLean, Scott Burdick, and CIRDLES.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.apache.tools.ant.filters.ReplaceTokens
import java.text.SimpleDateFormat
import java.util.*


plugins {
    java
    `java-library`
    id("de.jjohannes.extra-java-module-info") version "0.14"
    id("common-build") // Plugin calls common gradle build from buildSrc
}

dependencies {
//    implementation("de.jjohannes.gradle:extra-java-module-info:0.14")
    // https://mvnrepository.com/artifact/com.google.guava/guava
    implementation("com.google.guava:guava:31.1-jre")

    implementation("com.github.cirdles:commons:bc38781605")

    // https://mvnrepository.com/artifact/org.apache.commons/commons-math3
    implementation("org.apache.commons:commons-math3:3.6.1") // group: 'org.apache.commons', name: 'commons-math3', version: '3.6.1'
    // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
    implementation("org.apache.commons:commons-lang3:3.12.0")  //group: 'org.apache.commons', name: 'commons-lang3', version: '3.12.0'

    // https://mvnrepository.com/artifact/com.zaxxer/SparseBitSet
    implementation("com.zaxxer:SparseBitSet:1.2") //group: 'com.zaxxer', name: 'SparseBitSet', version: '1.2'
    // https://mvnrepository.com/artifact/org.apache.poi/poi
    implementation("org.apache.poi:poi:5.2.2") //group: 'org.apache.poi', name: 'poi', version: '5.2.2'

    // https://mvnrepository.com/artifact/gov.nist.math/jama
    //implementation group: 'gov.nist.math', name: 'jama', version: '1.0.3'
    // modernized update: https://github.com/topobyte/jama
    implementation("com.github.topobyte:jama:master-SNAPSHOT")

    // https://github.com/optimatika/ojAlgo
    // https://github.com/optimatika/ojAlgo/wiki/Optimisation-Modelling-Advice
    implementation("org.ojalgo:ojalgo:51.4.0")

    implementation("com.thoughtworks.xstream:xstream:1.4.19") //group: 'com.thoughtworks.xstream', name: 'xstream', version: '1.4.19'

    testImplementation("com.github.cirdles:commons:bc38781605")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}


tasks.test {
    useJUnitPlatform()
}


val timestamp = {
    SimpleDateFormat("dd MMMM yyyy").format(Date())
}


extraJavaModuleInfo {
    failOnMissingModuleInfo.set(false)
    automaticModule("commons-bc38781605.jar", "commons.bc38781605")
    // https://github.com/gradle/gradle/issues/12630
    automaticModule("org.apache.commons:commons-math3", "commons.math3")
    automaticModule("org.apache.commons:commons-lang3", "commons.lang3")
    automaticModule("com.zaxxer.SparseBitSet-1.2.jar", "com.zaxxer.SparseBitSet")
    automaticModule("jama-master-SNAPSHOT.jar", "jama")
    automaticModule("org.ojalgo:ojalgo", "ojalgo")
}


tasks.processResources {
    val tokens = mapOf("pom.version" to version, "timestamp" to timestamp())
    inputs.properties(tokens)

    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    from(sourceSets["main"].resources.srcDirs) {
        include("**/*.txt")
        filter<ReplaceTokens>("tokens" to tokens)
    }
}