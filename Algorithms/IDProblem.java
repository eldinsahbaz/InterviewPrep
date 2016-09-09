/*
Find the unique ID in a list of duplicate IDs
*/

public class IDProblem
	{
		public class ID
		{
			public String id;
			
			public ID(String identity) { id = identity; }
		}
	
		private ID[] idList;
	
		public test(String[] ids)
		{ 
			idList = new ID[ids.length];
			
			for(int i = 0 ; i < ids.length; i++)
				idList[i] = new ID(ids[i]);
		}
		
		public Integer findUnique()
		{
			if(idList != null)
			return findUnique(idList);
			
			return null;
		}
	
		private Integer findUnique(ID[] ids)
		{
			HashMap<String, Integer> ID_Hits = new HashMap<>();
			
			for(int i = 0; i < ids.length; i++)
			{
				if(ID_Hits.get(ids[i].id) == null)
					ID_Hits.put(ids[i].id, 1);
				else
					ID_Hits.put(ids[i].id, ++(ID_Hits.get(ids[i].id)));
			}
			
			for(Entry<String, Integer> set : ID_Hits.entrySet())
				if(set.getValue() == 1)
					return set.getKey();
		
			return null;
		}
}
