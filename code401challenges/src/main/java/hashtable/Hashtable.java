package hashtable;


public class Hashtable {

    private HashNode[] hashtable;

    public Hashtable(int size) {
        this.hashtable = new HashNode[size];
    }

    // hash() -> takes in an arbitrary key and returns an index in the collection
    public int hash(String key) {
        int hashValue = 0;

        char[] letters = key.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            hashValue += letters[i];
        }

        return (hashValue * 599) % hashtable.length;
    }

    // add() -> takes in both the key and value. This method should hash the key, and add the key and value pair to the table, handling collisions as needed
    public void add(String key, String value) {
        int hashedKey = hash(key);

        if (this.hashtable[hashedKey] == null ) {
            this.hashtable[hashedKey] = new HashNode(key, value);
        } else {
            HashNode temp = this.hashtable[hashedKey];
            this.hashtable[hashedKey] = new HashNode(key, value);
            this.hashtable[hashedKey].next = temp;
        }
    }

    // get() -> takes in the key and returns the value from the table
    public String get(String key) {
        int hashedKey = hash(key);

        if (this.hashtable[hashedKey] != null) {
            HashNode currentHashNode = this.hashtable[hashedKey];

            while(currentHashNode != null) {
                if (currentHashNode.key.equals(key)) {
                    return currentHashNode.value;
                }

                currentHashNode = currentHashNode.next;
            }
        }

        return null;
    }

    // contains() -> takes in the key and returns a boolean, indicating if the key exists in the table already
    public boolean contains(String key) {
        int hashedKey = hash(key);

        if (this.hashtable[hashedKey] != null) {
            HashNode currentHashNode = this.hashtable[hashedKey];

            while(currentHashNode != null) {
                if (currentHashNode.key.equals(key)) {
                    return true;
                }

                currentHashNode = currentHashNode.next;
            }
        }

        return false;
    }

    public void print() {
        for (int i = 0; i < this.hashtable.length; i++) {
            if (this.hashtable[i] != null) {
                HashNode currentHashNode = this.hashtable[i];

                while (currentHashNode != null) {
                    System.out.println("index: " + i + ", key: " + currentHashNode.key);
                    System.out.println("index: " + i + ", value: " + currentHashNode.value);
                    System.out.println("-----------------------------------");

                    currentHashNode = currentHashNode.next;
                }

            } else {
                System.out.println("index: " + i + ", " + this.hashtable[i]);
                System.out.println("-----------------------------------");
            }
        }
    }





}
