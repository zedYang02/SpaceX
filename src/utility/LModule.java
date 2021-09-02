package utility;

public class LModule {

	public static <T extends Comparable<T>> void selectionSort(List<T> list) {
		int minIndex;
		T current;
		T min;
		
		for(int i = 0;i<list.size()-1;i++) {
			minIndex = i;
			for(int j = i+1; j<list.size();j++) {
				current = list.get(j);
				min     = list.get(minIndex);
				if(current.compareTo(min)<0) {
					minIndex = j;
				}
			}
			
			if(minIndex != i) 
				swap(list,i,minIndex);
			
		}
	}
	private static <T> void swap(List<T> list, int a, int b) {
		T _a = list.get(a);
		T _b = list.get(b);
		list.set(a, _b);
		list.set(b, _a);
	}
}
