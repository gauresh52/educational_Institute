using System;
using System.Collections.Generic;
using System.IO;

class EducationalInstitute
{
    public int SrNo { get; set; }
    public string InstituteName { get; set; }
    public string City { get; set; }
    public string State { get; set; }
    public string Act { get; set; }
    public string Ministry { get; set; }

    public EducationalInstitute(int srNo, string instituteName, string city, string state, string act, string ministry)
    {
        SrNo = srNo;
        InstituteName = instituteName;
        City = city;
        State = state;
        Act = act;
        Ministry = ministry;
    }

    public void Display()
    {
        Console.WriteLine($"Sr.No.: \t\t{SrNo}");
        Console.WriteLine($"Name of the Institute: \t{InstituteName}");
        Console.WriteLine($"City: \t\t\t{City}");
        Console.WriteLine($"State: \t\t\t{State}");
        Console.WriteLine($"Act: \t\t\t{Act}");
        Console.WriteLine($"Ministry: \t\t{Ministry}\n");
    }
}

class Program
{
    static void Main(string[] args)
    {
        string filePath = "data/finalData.csv"; // Adjust the path as necessary
        List<EducationalInstitute> institutes = LoadInstitutesFromCSV(filePath);
        ShowMenu(institutes);
    }

    static List<EducationalInstitute> LoadInstitutesFromCSV(string filePath)
    {
        var institutes = new List<EducationalInstitute>();

        using (var reader = new StreamReader(filePath))
        {
            while (!reader.EndOfStream)
            {
                var line = reader.ReadLine();
                var values = line.Split(',');

                int srNo = int.Parse(values[0]);
                string instituteName = values[1].Trim('\"');
                string city = values[2];
                string state = values[3];
                string act = values[4].Trim('\"');
                string ministry = values[5];

                institutes.Add(new EducationalInstitute(srNo, instituteName, city, state, act, ministry));
            }
        }

        return institutes;
    }

    static void ShowMenu(List<EducationalInstitute> institutes)
    {
        while (true)
        {
            Console.WriteLine("\nMenu:");
            Console.WriteLine("1. Display all Educational Institutes");
            Console.WriteLine("2. Display Institutes by Name");
            Console.WriteLine("3. Display Institutes by State");
            Console.WriteLine("4. Display Institutes by Act");
            Console.WriteLine("5. Display Institutes by Ministry");
            Console.WriteLine("6. Exit");

            Console.Write("Enter your choice: ");
            string choice = Console.ReadLine();

            switch (choice)
            {
                case "1":
                    DisplayAllInstitutes(institutes);
                    break;
                case "2":
                    Console.Write("Enter name to search: ");
                    string name = Console.ReadLine();
                    DisplayInstitutesByName(institutes, name);
                    break;
                case "3":
                    Console.Write("Enter state to search: ");
                    string state = Console.ReadLine();
                    DisplayInstitutesByState(institutes, state);
                    break;
                case "4":
                    Console.Write("Enter act to search: ");
                    string act = Console.ReadLine();
                    DisplayInstitutesByAct(institutes, act);
                    break;
                case "5":
                    Console.Write("Enter ministry to search: ");
                    string ministry = Console.ReadLine();
                    DisplayInstitutesByMinistry(institutes, ministry);
                    break;
                case "6":
                    Console.WriteLine("Exiting...");
                    return;
                default:
                    Console.WriteLine("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    static void DisplayAllInstitutes(List<EducationalInstitute> institutes)
    {
        foreach (var institute in institutes)
        {
            institute.Display();
        }
    }

    static void DisplayInstitutesByName(List<EducationalInstitute> institutes, string name)
    {
        bool found = false;
        foreach (var institute in institutes)
        {
            if (institute.InstituteName.IndexOf(name, StringComparison.OrdinalIgnoreCase) >= 0)
            {
                institute.Display();
                found = true;
            }
        }
        if (!found)
        {
            Console.WriteLine($"No institutes found with the name: {name}");
        }
    }

    static void DisplayInstitutesByState(List<EducationalInstitute> institutes, string state)
    {
        bool found = false;
        foreach (var institute in institutes)
        {
            if (institute.State.IndexOf(state, StringComparison.OrdinalIgnoreCase) >= 0)
            {
                institute.Display();
                found = true;
            }
        }
        if (!found)
        {
            Console.WriteLine($"No institutes found in the state: {state}");
        }
    }

    static void DisplayInstitutesByAct(List<EducationalInstitute> institutes, string act)
    {
        bool found = false;
        foreach (var institute in institutes)
        {
            if (institute.Act.IndexOf(act, StringComparison.OrdinalIgnoreCase) >= 0)
            {
                institute.Display();
                found = true;
            }
        }
        if (!found)
        {
            Console.WriteLine($"No institutes found with the act: {act}");
        }
    }

    static void DisplayInstitutesByMinistry(List<EducationalInstitute> institutes, string ministry)
    {
        bool found = false;
        foreach (var institute in institutes)
        {
            if (institute.Ministry.IndexOf(ministry, StringComparison.OrdinalIgnoreCase) >= 0)
            {
                institute.Display();
                found = true;
            }
        }
        if (!found)
        {
            Console.WriteLine($"No institutes found with the ministry: {ministry}");
        }
    }
}
