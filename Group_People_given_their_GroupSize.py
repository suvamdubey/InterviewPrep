class Solution:
    def groupThePeople(self, g: List[int]) -> List[List[int]]:
        d = {}
        l=[]
        for i,j in enumerate(g):
            if j not in d.keys():
                d[j] = []
            d[j].append(i)
        for k in d.keys():
            t=[d[k][i:i + k] for i in range(0, len(d[k]), k)]
            for i in t:
                l.append(i)
            
        return l