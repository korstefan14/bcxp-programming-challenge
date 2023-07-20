package de.bcxp.challenge.models;


/**
 * This class is used to build ReducedWeatherInformation objects for testing purposes. I got the idea from http://www.natpryce.com/articles/000714.html 
 * (Although obviously the builder pattern is nothing new)
 */
public class ReducedWeatherInformationBuilder {
    int day = 1;
    int MnT = 1;
    int MxT = 1;

    public ReducedWeatherInformationBuilder withDay(int day) {
        this.day = day;
        return this;
    }

    public ReducedWeatherInformationBuilder withMnT(int MnT) {
        this.MnT = MnT;
        return this;
    }

    public ReducedWeatherInformationBuilder withMxT(int MxT) {
        this.MxT = MxT;
        return this;
    }

    public ReducedWeatherInformation build() {
        ReducedWeatherInformation reducedWeatherInformation = new ReducedWeatherInformation();
        reducedWeatherInformation.setDay(day);
        reducedWeatherInformation.setMnT(MnT);
        reducedWeatherInformation.setMxT(MxT);
        return reducedWeatherInformation;
    }

}
