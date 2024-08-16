import java.util.Scanner;
import java.util.regex.Pattern;
import grade.grade;
class Main
{
    int noofsubject;
    int internalMax,practicalMax,TheoryMax;
    String overallgrade;
    double overallpoint;
    int sumpoint;
    
    public static void main(String[] args) 
    {
        Scanner scanner=new Scanner(System.in);
        Main m=new Main();
        grade  g1 = new grade();
        try
        {
            System.out.println("Grading System.");
            System.out.println("Enter the number of subjects:");
            m.noofsubject = scanner.nextInt();
            if(m.noofsubject <=0 || String.valueOf(m.noofsubject).length()==0 || Pattern.matches("[a-zA-Z]", String.valueOf(m.noofsubject)))
            {
                throw m.new invalidInput();
            }

            String[] subjectlist=new String[m.noofsubject];
            int[] internallist=new int[m.noofsubject];
            int[] theorylist=new int[m.noofsubject];
            int[] practicallist=new int[m.noofsubject];
            String[] itgrade=new String[m.noofsubject];
            String[] pgrade=new String[m.noofsubject];
            int[] itgradepoint=new int[m.noofsubject];
            int[] pgradepoint=new int[m.noofsubject];
            String[] igrade=new String[m.noofsubject];
            String[] tgrade=new String[m.noofsubject];

            System.out.println("Enter the subject name:");
            for(int i=0;i<m.noofsubject;i++)
            {
                System.out.println("Enter subject "+(i+1)+" name:");
                String s=scanner.next();
                subjectlist[i]=s;
            }
            System.out.println("Enter the maximum marks for internal exam:");
            m.internalMax=scanner.nextInt();
            if(m.internalMax<=0 || String.valueOf(m.internalMax).length()==0 || Pattern.matches("[a-zA-Z]", String.valueOf(m.internalMax)))
            {
                throw m.new invalidInput();
            }
            System.out.println("Enter the maximum marks for theory exam:");
            m.TheoryMax=scanner.nextInt();
            if(m.internalMax<=0 || String.valueOf(m.TheoryMax).length()==0 || Pattern.matches("[a-zA-Z]", String.valueOf(m.TheoryMax)))
            {
                throw m.new invalidInput();
            }
            System.out.println("Enter the maximum marks for practical exam:");
            m.practicalMax=scanner.nextInt();
            if(m.practicalMax<=0 || String.valueOf(m.practicalMax).length()==0 || Pattern.matches("[a-zA-Z]", String.valueOf(m.practicalMax)))
            {
                throw m.new invalidInput();
            }

            for(int i=0;i<m.noofsubject;i++)
            {
                System.out.println("Enter "+subjectlist[i]+" marks:");
                System.out.println("Internal Marks:");
                int imarks=scanner.nextInt();
                if(imarks<0 || imarks>m.internalMax || String.valueOf(imarks).length()==0 || Pattern.matches("[a-zA-Z]", String.valueOf(imarks)))
                {
                    System.out.println("Enter Again...");
                    i--;
                    continue;
                }
                System.out.println("Practical Marks:");
                int pmarks=scanner.nextInt();
                if(pmarks<0 || pmarks>m.practicalMax || String.valueOf(pmarks).length()==0 || Pattern.matches("[a-zA-Z]", String.valueOf(pmarks)))
                {
                    System.out.println("Enter Again...");
                    i--;
                    continue;
                }
                System.out.println("Theory Marks:");
                int tmarks=scanner.nextInt();
                if(tmarks<0 || tmarks>m.TheoryMax || String.valueOf(tmarks).length()==0 || Pattern.matches("[a-zA-Z]", String.valueOf(tmarks)))
                {
                    System.out.println("Enter Again...");
                    i--;
                    continue;
                }

                internallist[i]=imarks;
                practicallist[i]=pmarks;
                theorylist[i]=tmarks;
            }
            for(int i=0;i<m.noofsubject;i++)
            {
                int max=m.internalMax+m.TheoryMax;
                int ittotal,ptotal,itpoint,ppoint;
                String itgradeString,ppointString,igradeString,tgradeString;
                ittotal=internallist[i]+theorylist[i];
                ptotal=practicallist[i];

                itgradeString=g1.calculateGrade(ittotal,max);
                ppointString=g1.calculateGrade(ptotal,m.practicalMax);

                igradeString=g1.calculateGrade(internallist[i],m.internalMax);
                tgradeString=g1.calculateGrade(theorylist[i], m.TheoryMax);

                itpoint=g1.calculateGradePoint(ittotal, max);
                ppoint=g1.calculateGradePoint(ptotal,m.practicalMax);

                itgrade[i]=itgradeString;
                pgrade[i]=ppointString;
                itgradepoint[i]=itpoint;
                pgradepoint[i]=ppoint;
                igrade[i]=igradeString;
                tgrade[i]=tgradeString;
                //System.out.println(itgrade[i]+pgrade[i]+igrade[i]+tgrade[i]+itgradepoint[i]+pgradepoint[i]);
            }

            for(int i=0;i<m.noofsubject;i++)
            {
                if(igrade[i]=="F" || tgrade[i]=="F" || pgrade[i]=="F")
                {
                    m.overallgrade= "F";
                    break;
                }
                else
                {
                    m.overallgrade=g1.overallGrade(itgradepoint, pgradepoint);
                }
            }
            //System.out.println("Overall Grade:"+m.overallgrade);

            if(m.overallgrade=="F")
            {
                m.overallpoint=0;
            }
            else
            {
                for(int i=0;i<m.noofsubject;i++)
                {
                    m.sumpoint=m.sumpoint+itgradepoint[i]+pgradepoint[i];
                } 
                m.overallpoint=m.sumpoint/((itgradepoint.length)+(pgradepoint.length));
            }
            
            //System.out.println("Overall Point:"+m.overallpoint+"\n");

            System.out.println("Subject Name  |  Internal Marks  |  Internal Grade  |  Theory Marks  |  Theory Grade  |  Total Marks  |  Grade");
            for(int i=0;i<m.noofsubject;i++)
            {
                if(igrade[i]=="F" || tgrade[i]=="F")
                {
                    System.out.println(subjectlist[i]+"  |  "+internallist[i]+"  |  "+igrade[i]+"  |  "+theorylist[i]+"  |  "+tgrade[i]+"  |  "+(internallist[i]+theorylist[i])+"  |  "+"--");
                }
                else
                {
                    System.out.println(subjectlist[i]+"  |  "+internallist[i]+"  |  "+igrade[i]+"  |  "+theorylist[i]+"  |  "+tgrade[i]+"  |  "+(internallist[i]+theorylist[i])+"  |  "+itgrade[i]);
                }
            }
            
            System.out.println("Subject Name  |  Practical Marks  |  Grade");
            for(int i=0;i<m.noofsubject;i++)
            {
                System.out.println(subjectlist[i]+"  |  "+practicallist[i]+"  |  "+pgrade[i]);
            }
            System.out.println("The overall grade is: "+m.overallgrade);
            System.out.println("The CGPA is: "+m.overallpoint);

        }
        catch(invalidInput ex)
        {
            System.out.println("Invalid Input, Please Start Again");
        }
        catch(Exception e)
        {
            System.out.println("Invalid Input, Please Start Again");
        }
        
    }
    class invalidInput extends Exception
    {
        invalidInput()
        {

        }
    }
}