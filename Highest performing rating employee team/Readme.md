Q. Company xyz.com has an organizational structure such that each employee in the company can have at most one manager
and may have many subordinates. The company recently conducted their quarterly performance review cycle and each employee has received a performance rating.

An example structure is as follows:

          A(5)
 B(3)                    C(1)

                D(4)             E(10)
A is the manager of B and C
C is the manager of D and E
Performance ratings are mentioned in brackets
Now given the employee information of a company, return the employee whose team has the highest performance rating average.
A team is defined as a group consisting of an employee and all their subordinates (not just the direct ones).
Sample input/output:
Input format: [employee name, rating, List]
data = [['A', 5, ['B', 'C']], ['B', 3, []], ['C', 2, ['D', 'E']], ['D', 4, []], ['E', 10, []]
Output: E

https://leetcode.com/discuss/post/1650545/rippling-se-dsalgo-round-highest-perform-4j8k/