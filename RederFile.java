
import java.util.List;
import java.io.*;
import java.util.Scanner;
public class RederFile <T> {







        private static Scanner in;
        private List<T> Class;
        private void ReadFile(List<T> Class) {
            String filePath = ".\\Resurs\\file.txt";

            try (FileReader fileReader = new FileReader(filePath);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {


                    String number = "";
                    String model = "";
                    String s ="";


                    double averageGrade=0;
                    int mileage=0;
                    int g = 0;

                    int d = 0;

                    if(line.indexOf("Bus")>=0)
                    {
                        g=1;


                        line =	line.replace("Bus = ","");
                    }

                    if(line.indexOf("Student")>=0)
                    {
                        g=3;

                        line =	line.replace("Student = ","");
                    }

                    if(line.indexOf("User")>=0)
                    {

                        g=2;

                        line =	line.replace("User = ","");
                    }

                    char[] charArray = line.toCharArray();
                    for (char chr : charArray) {
                        if ((chr != ',' )&&(chr != '\n')) {
                            if(d == 0)
                                number += chr;
                            if(d == 1) {
                                model += chr;
                            }
                            if(d == 2) {
                                s +=chr;

                            }
                        }
                        else
                        {
                            d++;
                        }

                    }
                    if(g == 1) {
                        mileage = Integer.parseInt(s.trim());
                        System.out.println("Bus = " +number + "  "  + model + "  " + mileage );
                    }




                    if(g==2) {
                        System.out.println("User = " + number + "  "  + model + "  " +  s );
                    }



                    if(g==3) {
                        averageGrade = Double.parseDouble(model);
                        System.out.println("Student = " + number + "  "  + averageGrade + "  " + s );

                    }
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }

        public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalAccessException, IOException {

        }

    }


