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

module Tripoli.TripoliCore {
    requires commons.bc38781605;
    requires org.apache.poi.poi;
    requires org.jetbrains.annotations;
    requires jama;
    requires ojalgo;
    requires com.google.common;
    requires commons.math3;
    requires commons.lang3;
    requires javafx.graphics;


    exports org.cirdles.tripoli;
    exports org.cirdles.tripoli.valueModels;
    exports org.cirdles.tripoli.utilities.stateUtilities;
    exports org.cirdles.tripoli.utilities.exceptions;
    exports org.cirdles.tripoli.species.nuclides;
    exports org.cirdles.tripoli.sessions.analysis.massSpectrometerModels.dataSourceProcessors;
    exports org.cirdles.tripoli.sessions.analysis.methods;
    exports org.cirdles.tripoli.sessions.analysis.methods.baseline;
    exports org.cirdles.tripoli.sessions.analysis.methods.sequence;
    exports org.cirdles.tripoli.species;
    exports org.cirdles.tripoli.elements;
    exports org.cirdles.tripoli.utilities.callbacks;
    exports org.cirdles.tripoli.sessions.analysis.massSpectrometerModels.dataOutputModels.mcmc;
    exports org.cirdles.tripoli.sessions.analysis.massSpectrometerModels.dataOutputModels.peakShapes;
    exports org.cirdles.tripoli.visualizationUtilities.histograms;
    exports org.cirdles.tripoli.visualizationUtilities.linePlots;
    exports org.cirdles.tripoli.visualizationUtilities;
    exports org.cirdles.tripoli.utilities;
}