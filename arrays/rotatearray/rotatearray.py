### Python Accepted Solution ###

class Solution(object):
    def rotate(self, nums, k):                                  #self here is the instance of the class itself                     
        if k is None or k <= 0:                                 #Edge case
            return
        k, end = k % len(nums), len(nums) - 1                   #Multivariable assignment
        self.reverse(nums, 0, end - k)
        self.reverse(nums, end - k + 1, end)
        self.reverse(nums, 0, end)
        
    def reverse(self, nums, start, end):
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start, end = start + 1, end - 1
