public class Main {

    //Один contains для всех
    public static boolean universalContains(char[] arr, char[] search, int startindex) {
        for (int i = 0; i < search.length; i++) {
            if (arr[i + startindex] != search[i]) {
                return false;
            }
        }
        return true;
    }

// 1. lTrim - metod udalyayet probeli s leva

    public static char[] lTrim(char[] arr) {
        int countSpaceL = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                countSpaceL++;
            } else {
                break;
            }
        }
        char[] newArr = new char[arr.length - countSpaceL];
        for (int i = countSpaceL, j = 0; i < arr.length; i++, j++) {
            newArr[j] = arr[i];
        }
        return newArr;
    }

// 2. RTrim - metod udalyayet probeli s prava

    public static char[] RTrim(char[] arr) {
        int countSpaceR = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == ' ') {
                countSpaceR++;
            } else {
                break;
            }
        }
        char[] newArr = new char[arr.length - countSpaceR];
        for (int i = countSpaceR, j = 0; i < arr.length; i++, j++) {
            newArr[j] = arr[i];
        }
        return newArr;
    }

// 3. Trim - metod udalyayet probeli s prava i s leva

    public static char[] myTrim(char[] arr) {
        int countSpaseL = 0;
        int countSpaseR = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                countSpaseL++;
            } else {
                break;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                countSpaseR++;
            } else {
                break;
            }
        }
        char[] arr2 = new char[arr.length - countSpaseL - countSpaseR];
//        System.out.println(arr2.length);
        for (int i = countSpaseL, j = 0; i < arr.length - countSpaseR; i++, j++) {
            arr2[j] = arr[i];
        }
        return arr2;
    }

// 4. equals - metod proveryayet s ucetom registra

    public static boolean myEquals(char[] arr3, char[] arr4) {
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] != arr4[i]) {
                return false;
//            } else if (arr3[i] == arr4[i]) {
//
            }
        }
        return true;
    }

// 5. startsWith - metod proveryayet nacinaetsa li stroka na ukazannuyu stroku

    public static boolean startsWith(char[] arr5, char[] arr6) {
        for (int i = 0; i < arr6.length; i++) {
            if (arr5[i] != arr6[i]) {
                return false;
            }
        }
        return true;
    }

// 6. replace - metod zamenyayet staruyu stroku na novuyu

    public static int countVxojdeniy(char[] arr, char[] search) {
        int count = 0;
        for (int i = 0; i <= arr.length - search.length; i++) {
            if (universalContains(arr, search, i)) {
                i += search.length;
                count++;
            }
        }
        return count;
    }

    public static int indexOfMy(char[] arr, char[] search, int start) {
        for (int i = start; i <= arr.length - search.length; i++) {
            if (universalContains(arr, search, i)) {
                return i;
            }
        }
        return -1;
    }

    public static char[] replaceAll(char[] original, char[] oldStr, char[] newStr) {
        int countEnter = countVxojdeniy(original, oldStr);

        if (countEnter == 0) {
            return original;
        }
        int newSize = original.length - (oldStr.length * countEnter) + (newStr.length * countEnter);
        char[] result = new char[newSize];
        int startIndex = 0;
        int findIndex = 0;
        int resultIndex = 0;
        while ((findIndex = indexOfMy(original, oldStr, startIndex)) != -1) {
            result = arrayCopy(original, startIndex, result, resultIndex, findIndex - startIndex);
            resultIndex += findIndex - startIndex;
            result = arrayCopy(newStr, 0, result, resultIndex, newStr.length);
            resultIndex += newStr.length;
            startIndex = findIndex + oldStr.length;
        }
        result = arrayCopy(original, startIndex, result, resultIndex, original.length - startIndex);
        return result;
    }

    public static char[] arrayCopy(char[] str, int strIndex, char[] dest, int destIndex, int leng) {
        for (int i = 0; i < leng; i++) {
            dest[destIndex + i] = str[strIndex + i];
        }
        return dest;
    }

// 7. equalsIgnoreCase - metod proveryayet bez uceta registra

    public static boolean myEqualsIgnoreCase(char[] one, char[] two) {
        if (one.length != two.length) {
            return false;
        }
        //one => nadya
        //two => NADYA
        for (int i = 0; i < one.length; i++) {
            char X = (one[i] >= 'A' && one[i] <= 'Z') ? (char) (one[i] + 32) : one[i];
            char Y = (two[i] >= 'A' && two[i] <= 'Z') ? (char) (two[i] + 32) : two[i];
            if (X != Y) {
                return false;
            }
        }
        return true;
    }

// 8. concat - metod kotoriy dobovlyayew k tekusey stroke novuyu stroku

    public static char[] concat(char[] arr, char[] arr2) {
        char[] result = new char[arr.length + arr2.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[arr.length + i] = arr2[i];
        }
        return result;
    }

// 9. endsWith - metod proveryayet zakancivaetsa li stroka na ukazannuyu stroku

    public static boolean endsWith(char[] arr5, char[] arr6) {
        for (int i = arr6.length - 1; i >= 0; i--) {
            if (arr5[arr5.length - arr6.length + i] != arr6[i]) {
                return false;
            }
        }
        return true;
    }

// 10. substring - metod izvlekaet pod stroku iz tekusey straki

    public static char[] substring(char[] arr, int startIndex, int endIndex) {
//        if (startIndex < 0 || endIndex > arr.length || startIndex > endIndex) {
//            System.out.println("Выбранный диапазон недоступен");
//        }
        char[] result = new char[endIndex - startIndex];
        for (int i = 0; i < endIndex - startIndex; i++) {
            result[i] = arr[startIndex + i];
        }
        return result;
    }

// 11. toCharArray - metod konvirtiruet stroku v massiv char

    public static char[] toCharArray(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

// 12. indexOf(char a) - metod vozvrasaet index dannoqo simvola

    public static int indexOf(char a) {
        char[] arr = {'N', 'a', 'D', '7', 'a'};
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] == a) {
                return i;
            }
        }
        return -1;
    }

// 13. indexOf(char a, int fromIndex) - metod vozvrasaet index dannoqo slova esli ono est nacinaya s fromIndex, inace -1

    public static int indexOf(char a, int fromIndex) {
        char[] arr2 = "Nadya? poshli kyshat bylky".toCharArray();
        if (fromIndex < 0 || fromIndex >= arr2.length) {
            return -1;
        }
        for (int i = fromIndex; i < arr2.length; i++) {
            for (int j = 0; j < a; j++) {
                if (arr2[i] == a) {
                    return i;
                }
            }
        }
        return -1;
    }

// 14. lastIndexOf(char a) - metod vozvrasaet index dannoqo simvola s konca, inace -1

    public static int lastIndexOf(char arr1) {
        char[] arr = {'n', 'A', 'd', '0', 'a'};
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == arr1) {
                return i;
            }
        }
        return -1;
    }

// 15. lastIndexOf(char a, int fromIndex) - metod vozvrasaet index dannoqo slova s konca esli ono est nacinaya s fromIndex, inace -1

    public static int lastIndexOf1(char a, int fromIndex) {
        char[] arr2 = "Nadya? poshli kyshat bylky".toCharArray();
        if (fromIndex < 0 || fromIndex >= arr2.length) {
            return -1;
        }
        for (int i = arr2.length - 1; i > fromIndex; i--) {
            for (int j = 0; j < a; j++) {
                if (arr2[i] == a) {
                    return i;
                }
            }
        }
        return -1;
    }

// 16. lastIndexOf(char[] a) - metod vozvrasaet index dannoqo slova s konca esli ono est, inace -1

    public static int lastIndexOf2(char[] arr, char[] arr2) {
        if (arr2.length > arr.length) {
            return -1;
        }
        for (int i = arr.length - arr2.length; i >= 0; i--) {
            boolean slovo = true;
            for (int j = 0; j < arr2.length; j++) {
                if (arr[i + j] != arr2[j]) {
                    slovo = false;
                    break;
                }
            }
            if (slovo) {
//                i += arr2.length - 1;
                return i;
            }
        }
        return -1;
    }

// 17. indexOf(char[] a) - metod vozvrasaet index dannoqo slova esli ono est, inace -1

    public static int indexOf2(char[] arr, char[] arr2) {
        if (arr2.length > arr.length) {
            return -1;
        }
        for (int i = 0; i <= arr.length - arr2.length; i++) {
            boolean slovo = true;
            for (int j = 0; j < arr2.length; j++) {
                if (arr[i + j] != arr2[j]) {
                    slovo = false;
                    break;
                }
            }
            if (slovo) {
                return i;
            }
        }
        return -1;
    }

// 18. indexOf(char[] a, int fromIndex) - metod vozvrasaet index dannoqo slova esli ono est nacinaya s fromIndex, inace -1

    public static int myIndexOf(char[] arr, char[] text, int fromIndex) {
        if (text.length > arr.length) {
            return -1;
        }
        if (fromIndex < 0) {
            for (int i = arr.length - text.length; i >= 0; i++) {
                if (universalContains(arr, text, i)) {
                    return i;
                }
            }
        } else {
            for (int i = fromIndex; i <= arr.length; i++) {
                if (universalContains(arr, text, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

// 19. lastIndexOf(char[] a, int fromIndex) - metod vozvrasaet index dannoqo slova s konca esli ono est nacinaya s fromIndex, inace -1

    public static int mylastIndexOf(char[] arr, char[] text, int fromIndex) {
        if (fromIndex >= arr.length) {
            for (int i = arr.length - text.length; i >= 0; i--) {
                if (universalContains(arr, text, i)) {
                    return -1;
                }
            }
        } else {
            for (int i = fromIndex; i >= 0; i--) {
                if (universalContains(arr, text, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

// 20. contains - metod proveryayet soderjit li stroka ukazannuyu stroku

    public static boolean contains(char[] arr, char[] str) {
        if (str.length > arr.length) {
            return false;
        }
        for (int i = 0; i <= arr.length - str.length; i++) {
            boolean arr2 = true;
            for (int j = 0; j < str.length; j++) {
                if (arr[i + j] != str[j]) {
                    arr2 = false;
                    break;
                }
            }
            if (arr2) {
                return true;
            }
        }
        return false;
    }

// 21. split - metod razdelyayet stroku na pod stroku

    public static String[] split(String text, String razdeli) {
        int count = 0;
        int nachalo = 0;
        int konec = 0;
        while (nachalo < text.length()) {
            konec = text.indexOf(razdeli, nachalo);
            if (konec == -1) {
                break;
            }
            count++;
            nachalo = konec + razdeli.length();
        }
        String[] pod = new String[count + 1];
        nachalo = 0;
        int index = 0;
        while (nachalo < text.length()) {
            konec = text.indexOf(razdeli, nachalo);
            if (konec == -1) {
                konec = text.length();
            }
            pod[index] = text.substring(nachalo, konec);
            index++;
            nachalo = konec + razdeli.length();
        }
        return pod;
    }



    public static void main(String[] args) {
        System.out.println();
        // 1
        System.out.print("1. Убавляет пробелы слева: ");
        char[] str = "     Nadezhda   ".toCharArray();
        System.out.println(lTrim(str).length);
        // 2
        System.out.print("2. Убавляет пробелы справа: ");
        char[] str1 = "     Nadezhda   ".toCharArray();
        System.out.println(RTrim(str1).length);
        // 3
        System.out.print("3. Убавляет пробелы справа и слева: ");
        String str2 = "   Nadezhda   Veronika   ";
//        System.out.println(str2.trim().length());
        char[] array = str2.toCharArray();
        char[] result = myTrim(array);
//        System.out.println(str2);
        System.out.println(result);
        // 4
        System.out.print("4. Проверка с учетом регистра: ");
        char[] arr3 = "naDYA".toCharArray();
        char[] arr4 = "NADYA".toCharArray();
        System.out.println(myEquals(arr3, arr4));
        // 5
        System.out.print("5. Начинается ли строка на указанную строку: ");
        char[] arr5 = "prifet sofia".toCharArray();
        char[] arr6 = "prifet".toCharArray();
        System.out.println(startsWith(arr5, arr6));
        // 6
        System.out.print("6. Замена старой строки на новую: ");
        char[] str6 = "privet, sofia. davay drujit, sofia?".toCharArray();
        char[] search = "sofia".toCharArray();
        char[] old = "nadya".toCharArray();
        char[] result6 = replaceAll(str6, search, old);
        for (int i = 0; i < result6.length; i++) {
            System.out.print(result6[i]);
        }
        System.out.println();
        // 7
        System.out.print("7. Проверка без учета регистра: ");
        char[] str7 = "Nadya".toCharArray();
        char[] str8 = "NADYA".toCharArray();
        if (myEqualsIgnoreCase(str7, str8)) {
            System.out.println("Равны");
        } else {
            System.out.println("Не равны");
        }
        // 8
        System.out.print("8. Добавляет к текущей строке новую строку: ");
        char[] str9 = "Nadya? privet, kak tvoi dela? ".toCharArray();
        char[] str10 = "davai drujit".toCharArray();
        char[] result8 = concat(str9, str10);
        System.out.println(result8);
        // 9
        System.out.print("9. Заканчивается ли строка на указанную строку: ");
        char[] arr9 = "prifet sofia".toCharArray();
        char[] arr10 = "sofia".toCharArray();
        System.out.println(endsWith(arr9, arr10));
        // 10
        System.out.print("10. Извлекает строку из подстроки: ");
        char[] str100 = "nadya, davai igrat".toCharArray();
        char[] arr100 = substring(str100, 7, 10);
        System.out.println(arr100);
        // 11
        System.out.print("11. Конвертирует строку в массив char: ");
        String str11 = "kak ti pojivaesh, nika?";
        char[] result11 = toCharArray(str11);
        for (int i = 0; i < result11.length; i++) {
            System.out.print(result11[i]);
        }
        System.out.println();
        // 12
        System.out.println("12. Индекс данного символа: " + indexOf('7'));
        // 13
        System.out.print("13. Возвращает индекс слова: ");
        int index13 = indexOf('s', 0);
        System.out.println(index13);
        // 14
        System.out.println("14. Индекс данного символа с конца: " + lastIndexOf('a'));
        // 15
        System.out.print("15. Возвращает индекс слова с конца: ");
        int index15 = lastIndexOf1('y', 0);
        System.out.println(index15);
        // 16
        System.out.print("16. Возвращает индекс данного слова с конца: ");
        char[] str16 = "Nadya poshli kyshat".toCharArray();
        char[] slovo16 = "kyshat".toCharArray();
        int index16 = lastIndexOf2(str16, slovo16);
        System.out.println(index16);
        // 17
        System.out.print("17. Возвращает индекс данного слова: ");
        char[] str17 = "Nadya poshli kyshat".toCharArray();
        char[] slovo17 = "poshli".toCharArray();
        int index17 = indexOf2(str17, slovo17);
        System.out.println(index17);
        // 18
        System.out.print("18. Последний индекс строки: ");
        String str18 = "java boolka privet";
        String search18 = "boolka";
        char[] strArr18 = str18.toCharArray();
        char[] searchArr18 = search18.toCharArray();
        int index18 = 5;
        int result18 = myIndexOf(strArr18, searchArr18, index18);
        System.out.println(search18 + " = " + result18);
        // 19
        System.out.print("19. Первый индекс строки: ");
        String str19 = "nadya veronika betu";
        String search19 = "betu";
        char[] strArr19 = str19.toCharArray();
        char[] searchArr19 = search19.toCharArray();
        int index19 = 15;
        int result19 = mylastIndexOf(strArr19, searchArr19, index19);
        System.out.println(search19 + " = " + result19);
        // 20
        System.out.print("20. Содержит ли строка указанную строку: ");
        char[] arr20 = "nadya veronika betu".toCharArray();
        char[] str20 = "veronika".toCharArray();
        System.out.println(contains(arr20, str20));
        // 21
        System.out.println("21. Разделяет строки на подстроки: ");
        String str21 = "Nadya poshli spat";
        String[] result21 = split(str21," ");
        for (int i = 0; i < result21.length; i++) {
            System.out.println(result21[i]);
        }
    }
}