# Why spend 20 minutes deciding which product t
# when you can relearn bayesian estimates and program it yourself?

# Telvin Zhong
# 6/23/2020

import sys
count = 1

# Bayesian average is calculated with four variables.
# Average review and total number of reviews are two naturally included variables.
# variable m is the value towards which we nudge services with a small number of reviews.
# m is also understandable as our best guess as to what the average rating should be.
# variable C represents how confident we are in the initial data.
# A smaller value for C will make it harder to move away from our guess value m.

# This version of bayesian avg uses values 3 and 5 for m and C respectively.
def bayesian_avg(avg, num):
    return (5 * 3 + avg * num) / (5 + num)

def calc_list(lst):
    print("_____RESULTS_____")
    for i in lst:
        print(i[0] + ": ")
        print("Average Rating: {:.1f}    Total number of reviews: {:d}".format(i[1], i[2]))
        print("Bayesian adjusted rating: {:.3f}\n".format(bayesian_avg(i[1], i[2])))

def ask_name():
    global count
    while True:
        name = input("Enter the name of item " + str(count) + ": ")
        if name in service:
            print("\nInput not valid. You have already entered this service.")
        else:
            break
    return name

def ask_avg():
    num = 0
    while True:
        try:
            num = float(input("Enter the average rating of the item out of five: "))
        except:
            print("\nInput not valid. Make sure you your input is a number without commas.")
        if num < 0 or num > 5:
            print("\nInput not valid. Make sure your rating is between 0 and 5.")
        else:
            break
    return float(num)

def ask_num():
    ans = 0
    while True:
        try:
            ans = (input("Enter the total number of ratings: "))
        except:
            print("\nInput not valid. Make sure your input is a number without commas.")
        if not str(ans).isdigit():
            print("\nInput not valid. Make sure your input is a number without commas.")
        elif int(ans) < 1:
            print("\nInput not valid. Make sure your input greater than zero.")
        else:
            break
    return int(ans)

service = []

# Change a rating from a 5 star scale to a number between 0 and 1.
# I thought I would need this but ended up not having to.
def toPercent(num):
    return (num - 1) / 4


def main():
    
    global count
    print("Welcome to the rating review program.\n")
    while True:
        name = ask_name()
        avg = ask_avg()
        num = ask_num()

        service.append([name, avg, num])

        check = input("\nType N to continue adding or press P to see results: ")
        if check == "N" or check == "n":
            count += 1
            print("\n")
            continue
        elif check == "P" or check == "p":
            count += 1
            break
        else:
            print("Please enter either N or P.\n")

    calc_list(service)
 
test = [["Web Design for Everybody, UMich", 4.7, 29780], ["Full-Stack Web Development, HK University", 4.7, 7257], ["HTML, CSS, and Javascript, John Hopkins", 4.8, 7131]]
print("Testing with some coursera courses:")
calc_list(test)

flag = input("Press any key to use this program yourself or press P to exit.")
if flag == "P" or flag == "p":
    sys.exit(0)

main()