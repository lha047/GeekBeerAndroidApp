package uib.pilsogprog.microbrewit.model;

public class Beer {
	
	int idMirobrewIt;
	String name;
	String style;
	String brewery;
	int myRating;
	double ABV;
	
	public Beer(int id, String name, String style, String brewery, int myRating,
			double aBV) {
		super();
		idMirobrewIt = id;
		this.name = name;
		this.style = style;
		this.brewery = brewery;
		this.myRating = myRating;
		ABV = aBV;
	}
	
	public Beer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getBrewery() {
		return brewery;
	}
	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}
	public int getMyRating() {
		return myRating;
	}
	public void setMyRating(int myRating) {
		this.myRating = myRating;
	}
	public double getABV() {
		return ABV;
	}
	public void setABV(double aBV) {
		ABV = aBV;
	}
	
}
