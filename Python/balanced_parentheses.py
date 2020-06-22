'''
Telvin Zhong
CS 5001
HW 7
'''


def balanced(s):
    stack = []
    for letter in s:
        if letter == '(':
            stack.append(letter)
        else:
            if len(stack) == 0:
                return False
            stack.pop()
    return len(stack) == 0
