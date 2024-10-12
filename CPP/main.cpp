#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>
#include <algorithm>

class EducationalInstitute {
public:
    int srNo;
    std::string instituteName, city, state, act, ministry;

    EducationalInstitute(int srNo, const std::string& instituteName, const std::string& city,
                         const std::string& state, const std::string& act, const std::string& ministry)
        : srNo(srNo), instituteName(instituteName), city(city), state(state), act(act), ministry(ministry) {}

    void display() const {
        std::cout << "Sr.No.: \t\t" << srNo << "\n"
                  << "Name of the Institute: \t" << instituteName << ".\n"
                  << "City: \t\t\t" << city << ".\n"
                  << "State: \t\t\t" << state << ".\n"
                  << "Act: \t\t\t" << act << ".\n"
                  << "Ministry: \t\t" << ministry << ".\n\n";
    }
};

std::vector<EducationalInstitute> loadInstitutesFromCSV(const std::string& filePath) {
    std::vector<EducationalInstitute> institutes;
    std::ifstream file(filePath);
    std::string line;

    while (std::getline(file, line)) {
        std::stringstream ss(line);
        std::string token;
        int srNo;
        std::string instituteName, city, state, act, ministry;

        std::getline(ss, token, ','); srNo = std::stoi(token);
        std::getline(ss, instituteName, ',');
        std::getline(ss, city, ',');
        std::getline(ss, state, ',');
        std::getline(ss, act, ',');
        std::getline(ss, ministry, ',');

        // Remove surrounding quotes if necessary
        if (instituteName[0] == '"') instituteName = instituteName.substr(1, instituteName.size() - 2);
        if (act[0] == '"') act = act.substr(1, act.size() - 2);
        
        institutes.emplace_back(srNo, instituteName, city, state, act, ministry);
    }

    return institutes;
}

void displayAllInstitutes(const std::vector<EducationalInstitute>& institutes) {
    for (const auto& institute : institutes) {
        institute.display();
    }
}

void displayInstitutesByName(const std::vector<EducationalInstitute>& institutes, const std::string& name) {
    bool found = false;
    for (const auto& institute : institutes) {
        if (institute.instituteName.find(name) != std::string::npos) {
            institute.display();
            found = true;
        }
    }
    if (!found) {
        std::cout << "No institutes found with the name: " << name << "\n";
    }
}

void displayInstitutesByState(const std::vector<EducationalInstitute>& institutes, const std::string& state) {
    bool found = false;
    for (const auto& institute : institutes) {
        if (institute.state.find(state) != std::string::npos) {
            institute.display();
            found = true;
        }
    }
    if (!found) {
        std::cout << "No institutes found in the state: " << state << "\n";
    }
}

void displayInstitutesByAct(const std::vector<EducationalInstitute>& institutes, const std::string& act) {
    bool found = false;
    for (const auto& institute : institutes) {
        if (institute.act.find(act) != std::string::npos) {
            institute.display();
            found = true;
        }
    }
    if (!found) {
        std::cout << "No institutes found with the act: " << act << "\n";
    }
}

void displayInstitutesByMinistry(const std::vector<EducationalInstitute>& institutes, const std::string& ministry) {
    bool found = false;
    for (const auto& institute : institutes) {
        if (institute.ministry.find(ministry) != std::string::npos) {
            institute.display();
            found = true;
        }
    }
    if (!found) {
        std::cout << "No institutes found with the ministry: " << ministry << "\n";
    }
}

void showMenu(const std::vector<EducationalInstitute>& institutes) {
    while (true) {
        std::cout << "\nMenu:\n";
        std::cout << "1. Display all Educational Institutes\n";
        std::cout << "2. Display Institutes by Name\n";
        std::cout << "3. Display Institutes by State\n";
        std::cout << "4. Display Institutes by Act\n";
        std::cout << "5. Display Institutes by Ministry\n";
        std::cout << "6. Exit\n";

        int choice;
        std::cout << "Enter your choice: ";
        std::cin >> choice;
        std::cin.ignore();  // Ignore newline character after integer input

        switch (choice) {
            case 1:
                displayAllInstitutes(institutes);
                break;
            case 2: {
                std::string name;
                std::cout << "Enter name to search: ";
                std::getline(std::cin, name);
                displayInstitutesByName(institutes, name);
                break;
            }
            case 3: {
                std::string state;
                std::cout << "Enter state to search: ";
                std::getline(std::cin, state);
                displayInstitutesByState(institutes, state);
                break;
            }
            case 4: {
                std::string act;
                std::cout << "Enter act to search: ";
                std::getline(std::cin, act);
                displayInstitutesByAct(institutes, act);
                break;
            }
            case 5: {
                std::string ministry;
                std::cout << "Enter ministry to search: ";
                std::getline(std::cin, ministry);
                displayInstitutesByMinistry(institutes, ministry);
                break;
            }
            case 6:
                std::cout << "Exiting...\n";
                return;
            default:
                std::cout << "Invalid choice! Please try again.\n";
                break;
        }
    }
}

int main() {
    std::string filePath = "data/finalData.csv";  // Adjust the path as necessary
    std::vector<EducationalInstitute> institutes = loadInstitutesFromCSV(filePath);
    showMenu(institutes);
    return 0;
}
