## Accepted Solutions

## This one is a classic approach... Pretty similar to the Java code
class SolutionClassic(object):
    def reverseString(self, s):
        r = list(s)
        i, j  = 0, len(r) - 1
        while i < j:
            r[i], r[j] = r[j], r[i]
            i += 1
            j -= 1

        return "".join(r)

## This is ultra Python approach! 
class SolutionPythonic(object):
    def reverseString(self, s):
        return s[::-1]