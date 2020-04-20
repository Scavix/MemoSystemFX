package model;

public enum Tags {
	BIO,MAT,GEN,IT,PSY;
	public static Tags stringa(String s) {
		if(s.equals(BIO.toString())) {return Tags.BIO;}
		else if(s.equals(IT.toString())) {return Tags.IT;}
		else if(s.equals(PSY.toString())) {return Tags.PSY;}
		else if(s.equals(MAT.toString())) {return Tags.MAT;}
		else {return Tags.GEN;}
	}
}
