/*
 *  Sample input/outputs:
 *    ("abcxyzab", ["ab", "bc"]) --> "<b>abc<\b>xyz<b>ab<\b>"
 *    ("abcxyzabab", ["ab", "bc"]) --> "<b>abc<\b>xyz<b>abab<\b>"
 *
 *  Bold the substrings that are in the pattern string array
 */

import java.util.Map;
import java.util.LinkedHashMap;

public static String boldString(String input, String[] patterns)
{
    if(input == null || patterns == null || input.length() < 1 || patterns.length == 0)
      return "";

    Map<Character, Boolean> bitmap = new LinkedHashMap<>();
    StringBuilder bolded = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    int last = 0;

    for(String str : patterns)
      for(int i = 0; i < str.length(); i++)
        bitmap.put(str.charAt(i), true);

    for(int i = 0; i < input.length(); i++)
    {
      if(bitmap.get(input.charAt(i))!= null && bitmap.get(input.charAt(i)))
        temp.append(input.charAt(i));
    else
    {
      if(temp != null && temp.length() > 0)
      {
        bolded.append("<b>" + temp.toString() + "<\\b>");
        temp.setLength(0);
      }

      bolded.append(input.charAt(i));
    }
  }

  if(temp != null && temp.length() > 0 && bitmap.get(temp.charAt(temp.length()-1)) != null)
    bolded.append("<b>" + temp.toString() + "<\\b>");
  else if(temp != null && temp.length() > 0)
    bolded.append(temp.toString());

    return bolded.toString();
}
