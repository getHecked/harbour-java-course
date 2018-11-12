
import junit.framework.TestCase;


public class HashMapTest extends junit.framework.TestCase{
    public HashMap map;
    
    public void setUp() {
        this.map = new HashMap();
    }

    public void testIsEmptyForNewMap() {
        assertTrue(map.isEmpty());
    }

    public void testAddMakesIsEmptyFalse() {
        map.put("Hello", 5);
        assertFalse(map.isEmpty());
    }

    public void testSizeForNewMap() {
        assertEquals(0, map.size());
    }
    

    public void testSizeIncrementsWhenAddingElements() {
        map.put("Hello", 5);
        assertEquals(1, map.size());

        map.put("Goodbye", 5);
        assertEquals(2, map.size());
    }

    public void testSizeDoesNotChange() {
        map.put("Hello", 5);
        map.put("Goodbye", 5);
        assertEquals(2, map.size());

        map.remove("Bye", 7);
        assertEquals(2, map.size());
    }

    public void testGetReturnsCorrectValue() {
        map.put("Hello", 5);
        map.put("Goodbye", 6);
        assertEquals(5, map.get("Hello"));
        assertEquals(6, map.get("Goodbye"));
    }
    

    public void testThrowsExceptionIfKeyDoesNotExist() {
        map.get("Hello");
    }

    public void testReplacesValueWithSameKey() {
        map.put("Hello", 5);
        map.put("Hello", 6);

        assertEquals(6, map.get("Hello"));
    }
    

    public void testDoesNotOverwriteSeperateKeysWithSameHash() {
        map.put("Ea", 5);
        map.put("FB", 6);

        assertEquals(5, map.get("Ea"));
        assertEquals(6, map.get("FB"));
    }
    
   
    public void testContainsKeyForNewMap() {
        assertFalse(map.containsKey("Hello"));
    }


    public void testRemoveDecrementsSize() {
        map.put("Hello", 5);
        map.put("Goodbye", 6);

        map.remove("Hello");

        assertEquals(1, map.size());

        map.remove("Goodbye");

        assertEquals(0, map.size());
    }

    public void testRemoveDeletesElement() {
        map.put("Hello", 5);
        map.remove("Hello");

        map.get("Hello");
    }


    public void testMediumSimple() {

        for (int i = 0; i < 10000; i++) {
            assertNull(map.put(Integer.toString(i), i));
            assertEquals(i + 1, map.size());
            int j = rand.nextInt(20000) - 5000;
            assertEquals(j >= 0 && j <= i ? (Integer)j : null, map.get(Integer.toString(j)));
        }
    }
   
  
    public void testContainsKeyForNonExistingKey() {
        map.put("Hello", 5);
        assertFalse(map.containsKey("Goodbye"));
    }

  

    public void testContainsKeyForExistingKey() {
        map.put("Hello", 5);
        assertTrue(map.containsKey("Hello"));
    }

  

    public void testContainsKeyForKeyWithEquivalentHash() {
        map.put("Ea", 5);

        assertFalse(map.containsKey("FB"));
    }

    private static Random rand = new Random();
    
    
    public void testRemoveDoesNotEffectNewMap() {
        map.remove("Hello");

        assertEquals(0, map.size());
    }

    public void testNotNull(){
        map.put("key1", "value 1");
        map.put("key2", "value 2");
        map.put("key3", "value 3");
        assertNotNull("key1");
    }

    public void testNotSame(){
        map.put("key1", "value 1");
        map.put("key2", "value 2");
        map.put("key3", "value 3");
        assertNotSame("key1", "key2");
    }

    public void testSame(){
        map.put("key1", "value 1");
        map.put("key2", "value 2");
        map.put("key3", "value 3");
        assertSame("key1", "key1");
    }

    public void destroy() {
        map.removeAll();
    }
}