package models;

public class Main {

    public static void main(String[] args) {

        int[] ar = {3,8,2}; // Stack ? ar , Heap ? 12bytes
        double[] db = {4.7, 8.2}; // Heap ? 16bytes
        System.out.println(ar);
        System.out.println(ar[2]);
        String str = "KIA"; // -> char[] = {'K','I','A'} // Heap ? 6bytes
        String[] s = {"KIA","VOLVO","FORD",""}; // Heap ?
/*        String[] s = {  |  , | , |, |}; // Heap ?
                          |    |--------> char[] = {"VOLVO"}
                    char[] = {'K','I','A'}


 */
        User user = new User();
        user.setName("John");
        user.setLastName("Silver");
//       new User("John","Silver","john@mail.com", "$Abcd1234");

        User user1 = new User().withName("Jack").withLastName("Sparrow");

    }

}

/*

OS 32bit, 64bit
32bit -> 4 bytes -> 4Gb
64bit -> 8 bytes -> 16 HexBytes (16 mln TB - 1024 Gb)

 address
[00000000]


main(){
int a = 5; 4 bytes [00000000][00000000][00000000][00000101]
char c = 3; 2 bytes
myMethod();
}
myMethod(){
int[] a = {3,8,2};
}
                        RAM ~ 16Gb
        Stack ~Mb                              Heap ~Gb

       main{
int a = 5; 4 bytes
char c = 3; 2 bytes

String str <---------------------------------- address {
                                                {'K','I','A'}
                                                }
String[] s <----------------------------------- address {
                                                char[] = {'K','I','A'},
                                                char[] = {"VOLVO"},
                                                char[] = {"FORD"},
                                                char[] = {}
                                                 }
             }
       myMethod(){
                           reference
int[] a  <-------------------------------------------- address {
                                                   int 3, i = 0
                                                   int 8, i = 1
                                                   int 2, i = 2
                                                   }
       }

LustInFirstOut

                            new Car();
 Car c  <--------------------X------------------ address {
                                                 int year = 2023 ? 4 bytes
                                                 String brand ? 8 bytes
                                                 double engine ? 8 bytes
                                                 }


                            new Car();
        <--------------------X------------------ address {
                                                 int year = 2023 ? 4 bytes
                                                 String brand ? 8 bytes
                                                 double engine ? 8 bytes
                                                 }

                            new User();
        <--------------------X------------------ address {
                                                 name = null
                                                 lastName = null
                                                 email = null
                                                 password = null
                                                 }
                            new User(name, lastName, email, password);
        <--------------------X------------------ address {
                                                 name = John
                                                 lastName = Silver
                                                 email = john@mail.com
                                                 password = $Abcd1234
                                                 }
                            new User(email, password);
        <--------------------X------------------ address {
                                                 name = John
                                                 lastName = Silver
                                                 email = jack@mail.com
                                                 password = $Abcd1256
                                                 }








 */