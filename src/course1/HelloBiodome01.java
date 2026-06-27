package course1;

public class HelloBiodome01 {
    static String name;
    public static void main(String[] args) {
        if (args.length != 0) {

            // 1, 정규식 활용
            name = args[0];

            String regex = "^(.{10}).*";
            String s = name.replaceAll(regex, "$1");

            System.out.println(s);


            // 2. char 변환 활용
//            char[] charArray = name.toCharArray();

//            try {
//                String s = String.valueOf(charArray, 0, 10);
//                System.out.println("안녕하세요, \"" + s + "\"님" );
//            } catch (StringIndexOutOfBoundsException s) {
//                System.out.println("안녕하세요, \"" + name + "\"님" );
//            }
        }
    }
}
