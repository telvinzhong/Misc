"""
Telvin Zhong
CS5001
Homework 5
29 February 2020
"""

'''
Test case 1
numbers = [-1,0,3,5,9,12]
Output: [-1, 0, 3, 5, 9, 12]

Test case 2
numbers = [23, 4, 42, 15, 16, 8, 3])
Output: [3, 4, 8, 15, 16, 23, 42]

Test case 3
numbers = [-1]
Output: [-1]

Test case 4
numbers = []
Output: []

Test case 5
numbers = [0, 1, 2, 3, 5, 4]
Output: [0, 1, 2, 3, 4, 5]

'''

"""
Function sorts a sequence of numbers in ascending order using merge sort.

Parameters:
numbers (list): A list of numbers to rearrange.

Returns:
result (list): The sorted list in ascending order.
"""

def mergesort(nums):
    # Base case to begin merging
    if len(nums) == 1:
        return nums

    # Recursively run mergesort on left and right halves
    left = nums[:len(nums) // 2]
    right = nums[len(nums) // 2:]
    L = mergesort(left)
    R = mergesort(right)

    ans = []
    # Append lower leading digit until both lists added.
    while L and R:
        if L[0] < R[0]:
            ans.append(L.pop(0))
        elif R[0] < L[0]:
            ans.append(R.pop(0))
        else:
            R.pop(0)
            ans.append(L.pop(0))
    if R:
        ans.extend(R)
    if L:
        ans.extend(L)
    return ans

a = [303, 215, 12, 330, 362, 7, 26, 53, 142, 388, 7, 83, 215, 141, 2, 148, 60, 361, 388, 215]
print("Before sorting: ")
print(a)
b = (mergesort([303, 215, 12, 330, 362, 7, 26, 53, 142, 388, 7, 83, 215, 141, 2, 148, 60, 361, 388, 215]))
print("After sorting: ")
print(b)