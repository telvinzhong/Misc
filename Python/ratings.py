# I unceremoniously rely on Yelp and wanted a way to know what was actually good.
# Then I learned Baye's theorem in class and that became my inspiration.
# It's also good for understanding reviews for things like Coursera and Amazon.

# Telvin Zhong
# 6/23/2020

import numpy as np

count = 1
flag = True
total = []

def sum(n):
    return n * (n + 1) / 2

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
    return num

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
    return ans

service = []


def how_happy(entry):
    return service[entry]

def main():
    global count
    print("Welcome to the rating review program.\n")
    while True:
        name = ask_name()
        avg = ask_avg()
        num = ask_num()

        service.extend([name, avg, num])

        check = input("Type N to continue adding or press P to see results: ")
        if check == "N" or check == "n":
            count += 1
            print("\n")
            continue
        elif check == "P" or check == "p":
            count += 1
            break
        else:
            print("Please enter either N or P.\n")

    for i in service:
        print(i)
main()