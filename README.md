# Stock Knapsack Project

**Source**: 
Ferris State University, 
Software Engineering Tools (SENG 355) Group Project

## Project Requirements
- Clients have a list of stocks and a fixed budget to spend.
- Each stock has price, price increase probability, and expected new price.
- The initial budget of clients are $2,500.00.
- A greedy (pick highest earning possible first until budget is met) strategy will be implemented.
- The amount for the greedy algorithm will be calculated by multiplying the possible profit if the price was to increase by the expected new price.
- An optimal algorithm will be implemented which calculates all possibilities and chooses the option with the greatest reward.
- At least ten test cases will be created.
- A table will be created comparing the algorithm performance between the greedy and the optimal solution for various stock amounts.

## Algorithm Comparisons

| Stocks                         | 10   | 25    | 50   | 100   | 250   | 500   | 1,000   | 5,000   | 10,000   | 15,000   |
|--------------------------------|------|-------|------|-------|-------|-------|---------|---------|----------|----------|
| Greedy Time (ms)               | 10   | 12    | 10   | 13    | 11    | 14    | 12      | 20      | 19       | 27       |
| Greedy Value (usd)             |      |       |      |       |       |       |         |         |          |          |
| Greedy Weight (current price)  |      |       |      |       |       |       |         |         |          |          |
| Optimal Time (ms)              | 15   | 2,111 | N/A  | N/A   | N/A   | N/A   | N/A     | N/A     | N/A      | N/A      |
| Optimal Value (usd)            |      |       |      |       |       |       |         |         |          |          |
| Optimal Weight (current price) |      |       |      |       |       |       |         |         |          |          |
| Optimal (Calculations)         | 2^10 | 2^25  | 2^50 | 2^100 | 2^250 | 2^500 | 2^1,000 | 2^5,000 | 2^10,000 | 2^15,000 |
