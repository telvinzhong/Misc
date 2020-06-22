# Prints all primes up to a number using the Sieve of Eratosthenes.

def Sieve(n):
    if n < 3:
        return 0
    nums = [1] * (n)
    nums[0] = nums[1] = 0
    # 0 means not prime, change multiples of primes to 0
    for i in range(2, n // 2 + 1):
        if nums[i] == 1:
            nums[2 * i::i] = [0] * len(nums[2 * i::i])
    return [i for i, value in enumerate(nums) if value == 1]

print(Sieve(100))