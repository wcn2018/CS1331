/**
 * @author William Chen
 * @version 1.0
 */
public class Store implements StoreOrganizer {
    private Animal[] pets;
    private int numPets;

    /**
     * constructor for Store which simply creates a store with
     * numPets pets.
     * @param numPets the number of pets this store has.
     *                Can't be changed later!
     */
    public Store(int numPets) {
        this.numPets = numPets;
        this.pets = new Animal[numPets];
    }
    //-------------------------------BASE GETTERS--------------------------------

    /**
     * getter for numPets
     * @return int numPets as declared in Store
     */
    public int getNumPets() {
        return numPets;
    }
    //---------------------------------OVERRIDES---------------------------------

    /**
     * a getter for the pets array.
     * @return the pets array, with all current pets
     */
    @Override
    public Animal[] getPets() {
        return pets;
    }

    /**
     * Adds an animal to the end of the list, without ever exceeding
     * the list's length. If list is full, prints "Out of room in pets[]!"
     * @param a the animal to be added to the inventory
     */
    @Override
    public void add(Animal a) {
        boolean qNull = false;
        int i = 0;
        Animal[] temp = this.pets;
        for (; i < temp.length; i++) {
            qNull = (temp[i] == null);
            if (qNull) {
                this.getPets()[i] = a;
                break;
            }
        } //lmao why can't I just use while(true) and break?
        if (!qNull) {
            System.out.println("Out of room in pets[]!");
        }
    }

    /***
     * sorts the pets array using a bubble sort
     * This method has average big O complexity of: O(n^2):
     * For list size n, there are n-1 "passes" through the list, and
     * each pass is size n-1, n-2, etc: num = i = 1->n SUM(n-i)
     * This approaches n passes of n operations, closest to n^2.
     */
    @Override
    public void sort() { //What size do the provided files initialize pets to?
        int firstNull = 0;
        Animal test = this.getPets()[firstNull];
        while (true) {
            if (firstNull == this.getPets().length) {
                break;
            }
            if (this.getPets()[firstNull] != null) {
                firstNull++;
            } else {
                break;
            }
        }
//        System.out.println(firstNull);
        int maxIndex = firstNull - 2;
        int end = maxIndex;
        while (end > 0) {
            for (int j = 0; j <= end; j++) {
                Animal temp1 = this.getPets()[j];
                Animal temp2 = this.getPets()[j + 1];
//                System.out.println(j);
//                System.out.println(temp1.toString() + "\n" + temp2.toString() + "\n");
                int comp = Animal.returnSimpleInts(temp1.compareTo(temp2));
                if (comp == 1) {
                    this.getPets()[j + 1] = temp1;
                    this.getPets()[j] = temp2;
                } else {
                    continue;
                }
            }
            end--;
        }
    }

    /**
     * Implements a binary search to find the specified animal
     * binary search is efficient: it has average big O complexity of: O(log(n))
     * for a list of n values, the absolute worst case for binary search is
     * x operations: 1 = n/(2^x).
     * Solving for x, we see: x = log2(n), so this is log(n) complexity.
     * NOTE: SORT MUST BE CALLED FIRST.
     * @param a the animal to search through the list
     * @return The index of the animal. If not found, returns -1
     */
    @Override
    public int binarySearch(Animal a) {
        int firstNull2 = 0;
        while (true) {
            if (firstNull2 == this.getPets().length) {
                break;
            }
            if (this.getPets()[firstNull2] != null) {
                firstNull2++;
            } else {
                break;
            }
        }

        int start = 0;
        int end = firstNull2 - 1;
        int mid = end / 2;
        if (this.getPets()[start].toString().compareTo(a.toString()) == 0) {
            return start;
        }
        if (this.getPets()[end].toString().compareTo(a.toString()) == 0) {
            return end;
        }

        while (true) {
//            System.out.println(start);
//            System.out.println(end);
//            System.out.println(a.compareTo(this.getPets()[mid]));
            switch (Animal.returnSimpleInts(a.compareTo(this.getPets()[mid]))) {
            case 1:
//                System.out.println(1);
                start = mid;
                mid = (end + start) / 2;
                break;
            case -1:
//                System.out.println(-1);
                end = mid;
                mid = (end + start) / 2;
                break;
            case 0:
                if (a.toString().compareTo(this.getPets()[mid].toString()) == 0) {
                    return mid;
                }
            default:
                return -1;
            }
//            System.out.println("=============================");
            if (end - start == 1) {
                break;
            }
        }
        return -1;
    }

    /**
     * Implements a linear search to find the specified animal
     * linear search is less efficient: it has average big O complexity of: O(n)
     * for a list of size n, the entry to be found is, on average, in the center
     * this makes for average number of operations: n/2, or a linear increase
     * in the number of operations as n increases.
     * @param a the animal to look for
     * @return the index where Animal a is found, or -1 if never found.
     */
    @Override
    public int linearSearch(Animal a) {
        int firstNull2 = 0;
        while (true) {
            if (firstNull2 >= this.getPets().length) {
                break;
            }
            if (this.getPets()[firstNull2] != null) {
                firstNull2++;
            } else {
                break;
            }
        }
//        System.out.println(firstNull2);
        for (int i = 0; i < firstNull2; i++) {
//            System.out.println(a.toString());
//            System.out.println(this.getPets()[i].toString());
//            System.out.println("==================================");
//            System.out.println(a.compareTo(this.getPets()[i]));
            if (Animal.returnSimpleInts(a.compareTo(this.getPets()[i])) == 0) {
                if (a.toString().compareTo(this.getPets()[i].toString()) == 0) {
//                    System.out.println(i);
                    return i;
                }
            } else if (Animal.returnSimpleInts(this.getPets()[i].compareTo(a)) == 1) {
//                System.out.println("no");
                return -1;
            }
        }
//        System.out.println("no2");
        return -1;
    }
}
