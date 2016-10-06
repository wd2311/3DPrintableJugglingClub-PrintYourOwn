package jugglingClubs;

public class JugglingClubCalculations {
	
	static float density = (float) .62;//ounces per cubic inch
	public static void main(String[] a){
		JugglingClubCalculations JCC1Object = new JugglingClubCalculations();
		JCC1Object.go();
	}//main
	
	public void go(){
		System.out.println("Club Fuction: ");
		//System.out.println("f(" + clubInput + ") (in.): " + functionClub(clubInput));
		System.out.println("Volume of Club (in.^3): " + volumeOfClub());
		
		System.out.println("");
		
		System.out.println("Hollow Function: ");
		//System.out.println("g(" + hollowInput + ") (in.): " + functionHollow(hollowInput));
		System.out.println("Volume of Hollow (in.^3): " + volumeOfHollow());
		
		System.out.println("");
		
		System.out.println("Solid Product: ");
		System.out.println("Volume of Solid (in.^3): " + volumeOfSolid());
		System.out.println("Density of Plastic (ounces/in.^3): " + density);
		System.out.println("Weight of Solid (ounces): " + weightOfSolidInOunces());
		
		System.out.println("");
		
		System.out.println("Volume Left of 57% (in.^3): " + volumeLeftOf57());
		System.out.println("Volume Rightof 57% (in.^3): " + (volumeOfSolid() - volumeLeftOf57()));
		System.out.println("Center of Volume (%): " + centerOfVolume());
	}//go
	
	private float centerOfVolume(){
		float halfVolumeOfSolid = (volumeOfSolid()/2);
		float volume = 0;
		for(float i = (float) 0; i <= 21; i = (i + (float) .001)){
			volume = volume + (float) (.001 * ((Math.pow(functionClub(i), 2) * Math.PI) - (Math.pow(functionHollow(i), 2) * Math.PI)));
			//if(Math.round(halfVolumeOfSolid) == Math.round(volume)){
			if(Math.abs(halfVolumeOfSolid - volume) <=.01){
				return (i/21);
			}
		}
		return -7;
	}//centerOfVolume
	
	private float volumeLeftOf57(){
		float volume = 0;
		for(float i = (float) 0; i < (float) 11.971; i = (i + (float) .001)){
			volume = volume + (float) (.001 * ((Math.pow(functionClub(i), 2) * Math.PI) - (Math.pow(functionHollow(i), 2) * Math.PI)));
		}//for
		return volume;
	}//volumeLeftOf57
	
	private float weightOfSolidInOunces(){
		return volumeOfSolid() * density;
	}//weightOfSolidInOunces
	
	private float volumeOfSolid(){
		/*
		float volume = 0;
		for(float i = (float) 0; i <= 21; i = (i + (float) .001)){
			volume = volume + (float) (.001 * ((Math.pow(functionClub(i), 2) * Math.PI) - (Math.pow(functionHollow(i), 2) * Math.PI))); //this way returns 52.6ish
		}//for
		return volume;
		*/
		return volumeOfClub() - volumeOfHollow();
	}//volumeOfSolid
	
	private float volumeOfHollow(){
		float volume = 0;
		for(float i = (float) 0; i <= 21; i = (i + (float) .001)){
			volume = volume + (float) (.001 * (Math.pow(functionHollow(i), 2) * Math.PI));
		}//for
		return volume;
	}//volumeOfHollowBasedOnAverage
	
	private float functionHollow(float x){ 
		float y = 0;
		if((x <= 0) || (x > 20.92)){
			y = 0;
		}
		if(x <= 1.38){
			if(x >= .4){
				y = (float) (-.9*(Math.pow(x-.75,2)) + .604);
				return y;
			}
		}
		if(x <= 9.3){
			y = (float) (.027*(x - 1.5)) + (float) .25;
			return y;
		}
		if(x <= 11){
			y = (float) (.222*x - 1.603);
			return y;
		}
		if(x <= 20.92){
			y = (float) (-.03 * Math.pow(x - 16, 2) + 1.59);
			return y;
		}//if else
		if(y >= 0){
			return y;
		}else{
			return 0;
		}
	}//functionHollow
	
	private float volumeOfClub(){
		float volume = 0;
		for(float i = (float) 0; i <= 21; i = (i + (float) .001)){
			volume = volume + (float) (.001 * ((Math.pow(functionClub(i), 2) * Math.PI))); //this way returns 52.6ish
		}//for
		return volume;
	}//volumeClub
	
	private float functionClub(float x){
		float y = 0;
		if((x < 0) || (x > 21)){
			y = 0;
		}else if(x <= 1.38){
			y = (float) Math.sqrt(.5625 - (Math.pow(x - .75, 2)));
		}else if(x <= 9.3){
			y = (float) (.032*(x - 1.38)) + (float) .41;
		}else if(x <= 11){
			y = (float) (Math.pow(1.2, x - 11.11) - .059);
		}else{
			y = (float) (-.03 * Math.pow(x - 16, 2) + 1.67);
		}//if else
		return y;
	}//functionClub
}//class

