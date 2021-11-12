/**
* Let's model list operations backed by memcached. We'll create a class that implements the List interface.

* Here's the memcached client interface:
*
* Memcached Interface
*  
    memcache.get(String key) -> returns the item that was previously stored under the key. returns null if the key does not exists.
*   
*  memcache.set(String key, String value) -> stores the value on a memcache server under the specified key
*   
*  memcache.incr(String key) -> increments a numeric item's value by 1. If the item's value is not numeric, an error will result. will set the item to 0 if the key doesn't exist. Returns the value.
*   
*
* Input:
*  mcl = new MCL(mc, "foo")
*  mcl.add("bar")
*  mcl.add("bar2")
*  mcl.add("42")
*  mcl.get(1)
*  Output:
*  "bar2"
* 
* The idea of putting the list in memcache is that this list
* can be shared by multiple services.
* 
* list to store in memcached, not in memory.
* receiving 
* 
* 
* Feel free to change the language, we're not looking for code that
* will compile but more about the modeling.
*/

class MCL implements List<String> {
    private final Memcache mcClient;
    private final String listName;
    
    public MCL(final Memcache mcClient, final String listName) {
        this.mcClient = mcClient;
        this.listName = listName;
    }
    
    public void add(final String value) {
    }
         
    
    public String get(final int index) {
    }
}
