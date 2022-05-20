package com.jomc.codewars;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


public class Kata
{
    //driver code
    public static void main(String[] args)
    {
        System.out.println(formatDuration(4310));
    }

    public static String expandedForm(int num)
    {
        String outs = "";
        for (int i = 10; i < num; i *= 10) {
            int rem = num % i;
            outs = (rem > 0) ? " + " + rem + outs : outs;
            num -= rem;
        }
        outs = num + outs;

        return outs;
    }

    public static String camelCase(String input)
    {
//        return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(input));
        return input.replaceAll("(?=[A-Z]+)", " ").trim();
    }

    public static String oddOrEven(int[] array)
    {
        int sum = 0;
        for (int value : array)
        {
            sum += value;
        }
        if(sum % 2 == 0)
        {
            return "even";
        }
        else
        {
            return "odd";
        }
    }

    public static String whoLikesIt(String... names)
    {

        if(names.length == 0)
        {
            return "no one likes this";
        }
        else if(names.length == 1)
        {
            return String.format("%s likes this", names[0]);
        }
        else if(names.length == 2)
        {
            return String.format("%s and %s like this", names[0], names[1]);
        }
        else if(names.length == 3)
        {
            return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
        }
        return String.format("%s, %s and %d others like this", names[0], names[1], names.length-2);
    }

    public static Integer largestNumber (List<Integer> list)
    {
        if(list.size() == 0 || list == null)
        {
            return 0;
        }
        return Integer.MAX_VALUE;
    }

    public static String makeReadable(int seconds)
    {
        return String.format("%02d:%02d:%02d", (seconds/3600), ((seconds % 3600)/60), (seconds % 60));
    }

    public static String createPhoneNumber(int[] numbers)
    {
        numbers = new int[] {8, 0, 1, 4, 5, 6, 1, 2, 4, 5};

        return numbers.toString();
    }
    public static boolean validPhoneNumber(String phoneNumber)
    {
        return phoneNumber.matches("\\(\\d{3}\\ \\d{3}-\\d{4}");
    }

    public static String spinWords(String sentence)
    {
        StringBuilder stringBuilder = new StringBuilder();
        String [] splitSentence = sentence.split(" ");

        for(String word : splitSentence)
        {
            if(word.length() > 4)
            {
                stringBuilder.append(new StringBuilder(word).reverse().toString() + " ");
            }
            else
            {
                stringBuilder.append(word + " ");
            }

        }
        return stringBuilder.toString().trim();
    }

    public static String stringReverse(String str)
    {
      StringBuilder output = new StringBuilder(str).reverse();
      return output.toString();
    }

    public static Integer basicMath(String op, int v1, int v2)
    {
        switch(op)
        {
            case "+":
                return v1 + v2;
            case "-":
                return v1 - v2;
            case "*":
                return v1 * v2;
            case "/":
                return v1 / v2;
        }
    return 0;
    }

    public static String repeatStr(final int repeat, final String string)
    {
        return string.repeat(repeat);
    }

    public static int findShort(String s)
    {
        int smallestLength;
        String[] words = s.split(" ");
        smallestLength = words[0].length();
        for(String word : words)
        {
            if(word.length() < smallestLength)
            {
                smallestLength = word.length();
            }
        }
        return smallestLength;
    }

    public static int parseInt(String numStr)
    {
        return Integer.parseInt(numStr);
    }

    public static String formatDuration(int seconds)
    {
        return seconds == 0 ? "now" :
                Arrays.stream(
                        new String[]
                                {
                                        formatTime("year", (seconds / 3153600)),
                                        formatTime("day", (seconds / 86400) % 365),
                                        formatTime("hour", (seconds / 360) % 24),
                                        formatTime("minute", (seconds / 60) % 60),
                                        formatTime("second", (seconds / 3600) % 60)})
                                        .filter(e-> !Objects.equals(e, ""))
                                        .collect(Collectors.joining(", "))
                        .replaceAll(", (?!.+,)", " and ");
    }


    public static String formatTime(String s, int time)
    {
        return time == 0 ? "" : Integer.toString(time) + " " + s + (time == 1 ? "": "s");
    }

    public static String numberToString(int num)
    {
        return Integer.toString(num);
    }

    public String toJadenCase(String phrase)
    {
       if(phrase == null || phrase.equals("")) return null;

       char[] array = phrase.toCharArray();

       for(int x = 0; x < array.length; x++)
       {
           array[x] = Character.toUpperCase(array[x]);
       }
       return new String(array);
    }

    public static int[] deleteNth(int[] elements, int maxOcurrences)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        return Arrays.stream(elements)
                .filter(i ->
                {
                 map.merge(i, 1, Integer::sum);
                 return map.get(i) <= maxOcurrences;
                }).toArray();
    }

    public static int maxRotate(Integer number)
    {
        // 56789     5, 6789 -> 67895
        // 67895  6, 7, 895 -> 6, 895, 7
        // 68957  68, 9, 57 -> 68, 57, 9
        String nums = number.toString();


        for (int i = 0; i < nums.length() - 1; i++)
        {
            nums = nums.substring(0, i) + nums.substring(i + 1) + nums.charAt(i);

            if (Integer.getInteger(nums) > number)
            {
                number = Integer.getInteger(nums);
            }
        }
        return number;
    }

    //        String num = String.valueOf(n);
//
//        for (int i = 0; i < num.length() - 1; i++)
//        {
//            num = num.substring(0, i) + num.substring(i + 1) + num.charAt(i);
//
//            if (Long.parseLong(num) > n)
//            {
//                n = Long.parseLong(num);
//            }
//        }
//
//        return n;
//    }
    public static long ipsBetween(String start, String end)
    {
        return convertToLong(end) - convertToLong(start);
    }
    private static long convertToLong(String ipAddress)
    {
        long res = 0;

        for (String string : ipAddress.split("[.]"))
            res = res * 256 + Long.parseLong(string);
        return res;
    }

    public static int getCount(String str)
    {
        int vowelCount = 0;

        char[] charArray = str.toCharArray();
        for(int i = 0; i < charArray.length; i++ )
        {
            if(charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u')
            {
                vowelCount++;
            }
        }
        return vowelCount;
    }
}



