import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Custom Comparator for comparing two PUBG Players
 * based on their KD (Kill / Death) Ratio and mvpCount
 */
class PUBGPlayerComparator implements Comparator<PUBGPlayer>{
	@Override
	public int compare(PUBGPlayer o1, PUBGPlayer o2) {
		if(o1 == o2) return 0;
		if((o1.mvpCount < o2.mvpCount) || (o1.kdRatio < o2.kdRatio)) return 1;
		return -1;
	}
}

public class July29thAssignment2 {
	public static void main(String[] args) {
		PUBGPlayer p1 = new PUBGPlayer("Sarvesh", 12546, 2564, 256);
		PUBGPlayer p2 = new PUBGPlayer("Dhamma", 8547, 1867, 157);
		PUBGPlayer p3 = new PUBGPlayer("Mayur", 7584, 2548, 121);
		PUBGPlayer p4 = new PUBGPlayer("Oshin", 9453, 3246, 93);
		PUBGPlayer p5 = new PUBGPlayer("Piyush", 10575, 5045, 86);
		PUBGPlayer p6 = new PUBGPlayer("Pratik", 9679, 3216, 145);
		
		ArrayList<PUBGPlayer> pubgPlayers = new ArrayList<PUBGPlayer>();
		pubgPlayers.add(p1);
		pubgPlayers.add(p2);
		pubgPlayers.add(p3);
		pubgPlayers.add(p4);
		pubgPlayers.add(p5);
		pubgPlayers.add(p6);
		Collections.sort(pubgPlayers, new PUBGPlayerComparator());
		for(PUBGPlayer p: pubgPlayers) {
			System.out.println(p);
		}
	}
}

class PUBGPlayer{
	String name;
	int kills;
	int matchesPlayed;
	float kdRatio;
	int mvpCount;
	
	public PUBGPlayer(String name, int kills, int matchesPlayed, int mvpCount) {
		super();
		this.name = name;
		this.kills = kills;
		this.matchesPlayed = matchesPlayed;
		this.kdRatio = kills / (float) matchesPlayed;
		this.mvpCount = mvpCount;
	}

	@Override
	public String toString() {
		return "PUBGPlayer [name=" + name + ", kills=" + kills + ", matchesPlayed=" + matchesPlayed + ", kdRatio="
				+ kdRatio + ", mvpCount=" + mvpCount + "]";
	}
}

