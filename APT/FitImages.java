import java.util.*;

class Image {
    int height;
    int width;
    Image(int h, int w) {
        this.height = h;
        this.width = w;
    }
}
class Column {
    int id;
    int height;
    Column(int id, int height) {
        this.id = id;
        this.height = height;
    }
}

class FitImages {
    public int minHeight(List<Image> list, int n) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        Collections.sort(list, (Image a, Image b) -> (b.height - a.height));
        //list.sort(Comparator.comparing(image -> image.height)); // reverse
        int m = list.size();
        if (list.size() <= n) {
            return list.get(m - 1).height;
        }
        Queue<Column> minHeap = new PriorityQueue<>(new Comparator<Column>(){
            public int compare(Column a, Column b) {
                return a.height - b.height;
            }
        });

        for (int i = 0; i < n; i++) {
            minHeap.offer(new Column(i, list.get(i).height));
        }

        for (int i = n; i < m; i++) {
            Column top = minHeap.poll();
            System.out.println("Top of heap with height:" + top.height + "\tindex " + top.id);
            top.height += list.get(i).height;
            minHeap.offer(top);
        }

        while (minHeap.size() > 1) {
            minHeap.poll();
        }
        return minHeap.poll().height;
    }

    public static void main(String[] args) {
        FitImages fit = new FitImages();
        Image a = new Image(2,1);
        Image b = new Image(14,1);
        Image c = new Image(4,1);
        Image d = new Image(16,1);
        Image e = new Image(6,1);
        Image f = new Image(5,1);
        Image g = new Image(3,1);
        List<Image> list = new ArrayList<Image>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);

        System.out.println(fit.minHeight(list, 3));
    }
}
