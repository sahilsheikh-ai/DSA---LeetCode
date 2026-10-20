
class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        result = []

        for n in nums1:
            if n in nums2:
                result.append(n)
                nums2.remove(n)

        return result
