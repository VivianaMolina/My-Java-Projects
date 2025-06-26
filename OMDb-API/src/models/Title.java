package models;

import exception.DurationConversionErrorException;

public class Title implements Comparable<Title>{
    private String name;
    private int releaseDate;
    private boolean includedInPlan;
    private double sumOfRatings;
    private int evaluationCount;
    private int runTime;

    public Title(String name, int releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public Title(TitleOmdb miTitleOmdb) {
        this.name = miTitleOmdb.title();
        this.releaseDate = Integer.valueOf(miTitleOmdb.year());
        if (miTitleOmdb.runtime().contains("N/A")){
            throw new DurationConversionErrorException("Duration could not be converted, " + 
                    "because it contains a N/A");
        }
        this.runTime = Integer.valueOf(
            miTitleOmdb.runtime().substring(0,3).replace(" ", ""));
    }

    public String getname() {
        return name;
    }

    public int getreleaseDate() {
        return releaseDate;
    }

    public boolean isincludedInPlan() {
        return includedInPlan;
    }

    public int getrunTime() {
        return runTime;
    }

    public int getevaluationCount() {
        return evaluationCount;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setreleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setincludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public void setrunTime(int runTime) {
        this.runTime = runTime;
    }

    public void muestraFichaTecnica(){
        System.out.println("name de la película: " + name);
        System.out.println("Año de lanzamiento: " + releaseDate);
    }

    public void evalua(double nota){
        sumOfRatings += nota;
        evaluationCount++;
    }

    public double calculaMediaEvaluaciones(){
        return sumOfRatings / evaluationCount;
    }

    @Override
    public int compareTo(Title otrotitle) {
        return this.getname().compareTo(otrotitle.getname());
    }

    @Override
    public String toString() {
        return "(name='" + name + 
                ", releaseDate=" + releaseDate+
                ", duracion=" + runTime+")";
    }

    
}


