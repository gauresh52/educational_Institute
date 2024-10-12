import csv

class EducationalInstitute:
    def __init__(self, sr_no, institute_name, city, state, act, ministry):
        self.sr_no = sr_no
        self.institute_name = institute_name
        self.city = city
        self.state = state
        self.act = act
        self.ministry = ministry

    def __str__(self):
        return (f"Sr.No.: \t\t{self.sr_no}\n"
                f"Name of the Institute: \t{self.institute_name}.\n"
                f"City: \t\t\t{self.city}.\n"
                f"State: \t\t\t{self.state}.\n"
                f"Act: \t\t\t{self.act}.\n"
                f"Ministry: \t\t{self.ministry}.\n")

def load_institutes_from_csv(file_path):
    institutes = []
    with open(file_path, newline='', encoding='utf-8') as csvfile:
        reader = csv.reader(csvfile)
        for row in reader:
            if len(row) >= 6:
                sr_no = int(row[0].strip())
                name = row[1].strip()
                city = row[2].strip()
                state = row[3].strip()
                act = row[4].strip()
                ministry = row[5].strip()
                institute = EducationalInstitute(sr_no, name, city, state, act, ministry)
                institutes.append(institute)
    return institutes

def display_all_institutes(institutes):
    for institute in institutes:
        print(institute)

def display_institutes_by_name(institutes, name):
    found = False
    for institute in institutes:
        if name.lower() in institute.institute_name.lower():
            print(institute)
            found = True
    if not found:
        print(f"No institutes found with the name: {name}")

def display_institutes_by_state(institutes, state):
    found = False
    for institute in institutes:
        if state.lower() in institute.state.lower():
            print(institute)
            found = True
    if not found:
        print(f"No institutes found in the state: {state}")

def display_institutes_by_act(institutes, act):
    found = False
    for institute in institutes:
        if act.lower() in institute.act.lower():
            print(institute)
            found = True
    if not found:
        print(f"No institutes found with the act: {act}")

def display_institutes_by_ministry(institutes, ministry):
    found = False
    for institute in institutes:
        if ministry.lower() in institute.ministry.lower():
            print(institute)
            found = True
    if not found:
        print(f"No institutes found with the ministry: {ministry}")

def show_menu(institutes):
    while True:
        print("\nMenu:")
        print("1. Display all Educational Institutes")
        print("2. Display Institutes by Name")
        print("3. Display Institutes by State")
        print("4. Display Institutes by Act")
        print("5. Display Institutes by Ministry")
        print("6. Exit")

        choice = input("Enter your choice: ")

        if choice == '1':
            display_all_institutes(institutes)
        elif choice == '2':
            name = input("Enter name to search: ")
            display_institutes_by_name(institutes, name)
        elif choice == '3':
            state = input("Enter state to search: ")
            display_institutes_by_state(institutes, state)
        elif choice == '4':
            act = input("Enter act to search: ")
            display_institutes_by_act(institutes, act)
        elif choice == '5':
            ministry = input("Enter ministry to search: ")
            display_institutes_by_ministry(institutes, ministry)
        elif choice == '6':
            print("Exiting...")
            break
        else:
            print("Invalid choice! Please try again.")

def main():
    file_path = 'data/finalData.csv'  # Adjust the path as necessary
    institutes = load_institutes_from_csv(file_path)
    show_menu(institutes)

if __name__ == "__main__":
    main()
