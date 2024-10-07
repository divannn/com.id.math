package w2.task1;


import java.util.HashSet;

public class KK<T> {

    private HashSet<T> data = new HashSet();

    private WeightedGraph g;
    int dist;

    public KK(WeightedGraph g) {
        this.g = g;
    }

    public KK merge(KK value) {
        data.addAll(value.data);
        return this;
    }

    public boolean add(T value) {
        return data.add(value);
    }

    public boolean has(T value) {
        return data.contains(value);
    }

    @Override
    public String toString() {
        return "KK{" +
                "data=" + data +
                '}';
    }

/*public int getMinW() {
		Iterator<T> it = data.iterator();
		while (it.hasNext()) {
			T v = it.next();
			g.adj(v)
		}
	}*/
}
