package course1;

public class HelloBiodome01 {
    static String name;
    public static void main(String[] args) {
        if (args.length != 0 && !args[0].isBlank()) {

            // 1, 정규식 활용
            name = String.join(" ", args);

            String regex = "^(.{10}).*";
            String s = name.replaceAll(regex, "$1");

            System.out.println("안녕하세요, \"" + s + "\"님");


            // 2. char 변환 활용
//            char[] charArray = name.toCharArray();

//            try {
//                String s = String.valueOf(charArray, 0, 10);
//                System.out.println("안녕하세요, \"" + s + "\"님" );
//            } catch (StringIndexOutOfBoundsException s) {
//                System.out.println("안녕하세요, \"" + name + "\"님" );
//            }
        } else {
            System.out.println("이름을 입력해 주세요");
        }
    }
}
