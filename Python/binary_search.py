"""
Telvin Zhong
CS5001
29 February 2020
"""

"""
Function searches for the index of a target number using binary search.

Parameters:
target (int): Target number to search for.
numbers (List): A list of numbers to scan.

Returns:
pivot(int): The index position of x if x is present in the list.
"""


def binary_search(target, numbers):
    left, right = 0, len(nums) - 1
    while left <= right:
        pivot = (left + right) // 2
        if target < nums[pivot]:
            right = pivot - 1
        elif target > nums[pivot]:
            left = pivot + 1
        else:
            return pivot
    return -1

nums = [-13,-9,-7,-1,0,2,3,5,9,11,12,19,22]
print(binary_search(12, nums))
