import java.util.*;
import java.util.Map.Entry;

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

public class July29thAssignment3 {
	public static void main(String[] args)
	{
				TreeMap<PUBGPlayer, Integer> tree_map
					= new TreeMap<PUBGPlayer, Integer>(
						new PUBGPlayerComparator());
				tree_map.put(new PUBGPlayer("Sarvesh", 12546, 2564, 256),1);
				tree_map.put(new PUBGPlayer("Dhamma", 8547, 1867, 157),2);
				tree_map.put(new PUBGPlayer("Mayur", 7584, 2548, 121),3);
				tree_map.put(new PUBGPlayer("Oshin", 9453, 3246, 93),4);
				tree_map.put(new PUBGPlayer("Piyush", 10575, 5045, 86),5);
				
				 Set<Entry<PUBGPlayer, Integer>> entries
		            = tree_map.entrySet();
				
//				System.out.println("TreeMap: " + tree_map);
				for (Map.Entry<PUBGPlayer, Integer> entry : entries) {
		            System.out.println(entry.getKey() + "->"
		                               + entry.getValue());
		        }
		
	}
}
