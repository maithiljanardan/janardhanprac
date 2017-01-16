package org.janardhan.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author jd
 * 
 */
public class HashMapImpl {

	public static void main(String[] args) {

		Map<HashMapKeyObj, String> map = new HashMap<>();

		HashMapKeyObj obj1 = new HashMapKeyObj("jd", "Janardhan Maithil");
		HashMapKeyObj obj2 = new HashMapKeyObj("dk", "Adil Khan");
		HashMapKeyObj obj3 = new HashMapKeyObj("na", "Nitesh Adjriya");
		HashMapKeyObj obj4 = new HashMapKeyObj("gk", "Gaurav Somvanshi");
		HashMapKeyObj obj5 = new HashMapKeyObj("tatti", "Vishal Srivastava");
		HashMapKeyObj obj6 = new HashMapKeyObj("jd", "Janardhan Maithil");
		HashMapKeyObj obj7 = new HashMapKeyObj("dk", "Adil Khan");

		map.put(obj1, "Main hu jd");
		map.put(obj2, "Main hu Adil");
		map.put(obj3, "Main hu Na");
		map.put(obj4, "Main hu gk");
		map.put(obj5, "Main hu vishal");

		System.out.println(map.get(obj6) + "\n");

		// Iterating over hashmap using foreach
		// keySet() method returns Set<K>
		System.out.println("Iterating Map using foreach ");

		for (HashMapKeyObj obj : map.keySet()) {
			System.out.println("Key " + obj.toString() + " values " + map.get(obj));
		}

		// Iterating using keyset iterator
		System.out.println("\n Iterating Map using keyset iterator ");

		Set<HashMapKeyObj> keySet = map.keySet();
		Iterator<HashMapKeyObj> iterator = keySet.iterator();

		while (iterator.hasNext()) {

			HashMapKeyObj key = iterator.next();
			System.out.println("Key " + key.toString() + " value " + map.get(key));
		}

		// Iterating using entryset
		System.out.println("\n Iterating Map using entrySet ");

		Set<Map.Entry<HashMapKeyObj, String>> entrysSet = map.entrySet();

		for (Entry<HashMapKeyObj, String> entry : entrysSet) {
			System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
		}

		// Iterating using entryset iterator
		System.out.println("\n Iterating Map using entrySet iterator");
		Set<Map.Entry<HashMapKeyObj, String>> entrysSet1 = map.entrySet();

		Iterator<Entry<HashMapKeyObj, String>> iter = entrysSet1.iterator();
		while (iter.hasNext()) {
			Entry<HashMapKeyObj, String> entry = iter.next();
			System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
		}

	}
}
