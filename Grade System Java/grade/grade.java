package grade;

public class grade 
{
    public String calculateGrade(int marks,int total) 
    {
        double percentage = (double) marks / total * 100;
        if (percentage >= 80) 
        {
            return "O";
        } else if (percentage < 80 && percentage>=70) 
        {
            return "A+";
        } else if (percentage >= 60 && percentage<70) 
        {
            return "A";
        } else if (percentage >= 55 && percentage<60) 
        {
            return "B+";
        } else if (percentage >= 50 && percentage<55) 
        {
            return "B";
        } else if (percentage >= 45 && percentage<50) 
        {
            return "C";
        } 
        else if (percentage >= 40 && percentage<45) 
        {
            return "D";
        }
        else {
            return "F";
        }
    }
    public int calculateGradePoint(int marks,int total) 
    {
        double percentage = (double) marks / total * 100;
        if (percentage >= 80) 
        {
            return 10;
        } else if (percentage < 80 && percentage>=70) 
        {
            return 9;
        } else if (percentage >= 60 && percentage<70) 
        {
            return 8;
        } else if (percentage >= 55 && percentage<60) 
        {
            return 7;
        } else if (percentage >= 50 && percentage<55) 
        {
            return 6;
        } else if (percentage >= 45 && percentage<50) 
        {
            return 5;
        } 
        else if (percentage >= 40 && percentage<45) 
        {
            return 4;
        }
        else {
            return 0;
        }
    }

    public String overallGrade(int point1[],int point2[])
    {
        int sum=0,avg;
        for(int i=0;i<point1.length;i++)
        {
            sum=sum+point1[i]+point2[i];
        }
        avg=sum/((point1.length)+(point2.length));
        if(avg==10)
        {
            return "O";
        }
        else if(avg>=9)
        {
            return "A+";
        }
        else if(avg>=8)
        {
            return "A";
        }
        else if(avg>=7)
        {
            return "B+";
        }
        else if(avg>=6)
        {
            return "B";
        }
        else if(avg>=5)
        {
            return "C";
        }
        else if(avg>=4)
        {
            return "D";
        }
        else
        {
            return "F";
        }
    }
}
