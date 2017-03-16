package com.example.myles.sprint2;

import android.provider.BaseColumns;

/**
 * Created by Kunal Gulati on 2017-03-13.
 */

public class DepartmentList {

        public DepartmentList()
        {

        }


        public static abstract class DepartmentInfo
        {


            // Name of Faculties
            public static  String[] Faculty = new String[]{"Faculty of Applied Science","Beedie School of Business",
                    "Faulty of Education", "Faculty of Environment",
                    "Faculty of Science", "Faculty of Health Sciences",
                    "Faculty of Communication, Art and Technology", "Faculty of Arts and Social Sciences"
            };

            public static String[][] Department = {
                    { "School of Computing Science", "School of Engineering Science","School of Mechatronic Systems Engineering" },
                    {"Beedie School of Business"},
                    {"Department of Education" },
                    { "Faculty of Environment home",
                            "Department of Archaeology" , "Centre for Sustainable Community Development" ,
                            "Environmental Science program" , "Department of Geography" ,
                            "School of Resource and Environmental Management" ,
                            "Bachelor of Environment" , "Ecological Restoration" ,
                            "Heritage Resource Management" , "Resource and Environmental Planning" },
                    { "Department of Sciences" },
                    { "Department of Health Sciences" },
                    { "School of Communication" , "School for the Contemporary Arts" ,
                            "School of Interactive Arts and Technology" , "Publishing program"
                    },
                    { "Department of Sociology and Anthropology", "Asia-Canada program",
                            "Cognitive Science program", "School of Criminology",
                            "Department of Economics", "Department of English",
                            "Department of First Nations Studies", "French Cohort program",
                            "Department of French", "Department of Gender, Sexuality, and Women's Studies",
                            "Department of Gerontology", "Graduate Liberal Studies program",
                            "Hellenic Studies program", "Department of History",
                            "Department of Humanities", "School for International Studies",
                            "Labour Studies program", "Language Training Institute",
                            "Latin American Studies program", "Department of Linguistics",
                            "Department of Philosophy", "Department of Political Science",
                            "Department of Psychology", "School of Public Policy",
                            "Urban Studies program", "World Literature program"}
            };


            // List of departments in "Arts and Social Scince"
            public static final String[] ArtsAndSocialScience = new String[]{ "Department of Sociology and Anthropology", "Asia-Canada program",
                "Cognitive Science program", "School of Criminology",
                "Department of Economics", "Department of English",
                "Department of First Nations Studies", "French Cohort program",
                "Department of French", "Department of Gender, Sexuality, and Women's Studies",
                "Department of Gerontology", "Graduate Liberal Studies program",
                "Hellenic Studies program", "Department of History",
                "Department of Humanities", "School for International Studies",
                "Labour Studies program", "Language Training Institute",
                "Latin American Studies program", "Department of Linguistics",
                "Department of Philosophy", "Department of Political Science",
                "Department of Psychology", "School of Public Policy",
                "Urban Studies program", "World Literature program"
            };

            // List of departments in "Applied Science"
            public static final String[] AppliedScience = new String[]{
                    "School of Computing Science", "School of Engineering Science",
                            "School of Mechatronic Systems Engineering"
            };

            // List of departments in "Business"
            public static final String[] Business = new String[]{ "Beedie School of Business" };

            // List of Departments in "Communications, Arts and Tech"
            public static final String[] Communication = new String[]{ "School of Communication" ,
                    "School for the Contemporary Arts" , "School of Interactive Arts and Technology" ,
                    "Publishing program"
            };

            // List of Departments in "Education, Arts and Tech"
            public static final String[] Education = new String[]{ "Department of Education" };


            // List of Departments in "Enviornmental Education"
            public static final String[] Environment = new String[]{ "Faculty of Environment home",
                    "Department of Archaeology" , "Centre for Sustainable Community Development" ,
                    "Environmental Science program" , "Department of Geography" ,
                    "School of Resource and Environmental Management" ,
                    "Bachelor of Environment" , "Ecological Restoration" ,
                    "Heritage Resource Management" , "Resource and Environmental Planning" };

            // List of Departments in "Health Science"
            public static final String[] HealthScience = new String[]{ "Department of Health Sciences" };

            // List of Departments in "Science"
            public static final String[] Science = new String[]{ "Department of Sciences" };

        }

}
