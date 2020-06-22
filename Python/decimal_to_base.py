"""
Telvin Zhong
CS5001
Homework 4
15 February 2020
"""

'''
Test case 1
50
'62'

Test case 2
0
'0'

Test case 3
1
'1'

Test case 4
9
'11'

Test case 5
670
'1236'

'''

"""
Function converts a base 10 number to base 8.

Parameters:
decimal (int): Input should be an integer in base ten.

Returns:
octal_value (str): Returns a string with the input number in base 8.
"""


def decimal_convert(decimal):
    base = int(input("Choose a base for conversion. This program supports numbers between 2 and 36.\n"))
    if base < 2 or base > 32:
        print("Input not valid. Exiting program.")
        exit()
    base = int(base)
    ans = ""
    # Raise an exception for 0
    if decimal == 0:
        return '0'
    else:
        while decimal != 0:
            # Find the remainder over the greatest multiple of 8
            digit = decimal % base
            # This number becomes the leftmost digit in base 8
            ans = str(digit) + ans
            # Repeat the process for smaller multiples of 8
            decimal = decimal // base
    return ans

print(decimal_convert(100))
