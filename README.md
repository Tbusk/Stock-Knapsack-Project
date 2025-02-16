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

x = too long to run / cpu / memory limitations reached

| Stocks                         | 10     | 25       | 50       | 100      | 250      | 500      | 1,000    | 5,000     | 10,000    | 15,000    |
|--------------------------------|--------|----------|----------|----------|----------|----------|----------|-----------|-----------|-----------|
| Greedy Time (ms)               | 9      | 8        | 16       | 16       | 15       | 17       | 13       | 25        | 29        | 27        |
| Greedy Value (usd)             | 336.44 | 372.07   | 1,277.01 | 2,546.20 | 4,943.88 | 7,168.11 | 9,916.10 | 17,920.12 | 21,768.62 | 26,273.57 |
| Greedy Weight (current price)  | 449.66 | 1,395.18 | 2,439.55 | 2,494.85 | 2,499.65 | 2,499.92 | 2,499.88 | 2,499.94  | 2,500.00  | 2,500.00  |
| Optimal Time (ms)              | 16     | 2,575    | x        | x        | x        | x        | x        | x         | x         | x         |
| Optimal Value (usd)            | 345.28 | 473.25   | x        | x        | x        | x        | x        | x         | x         | x         |
| Optimal Weight (current price) | 366.58 | 872.13   | x        | x        | x        | x        | x        | x         | x         | x         |
| Optimal (Solutions)            | 2^10   | 2^25     | 2^50     | 2^100    | 2^250    | 2^500    | 2^1,000  | 2^5,000   | 2^10,000  | 2^15,000  |
| DP Time (ms)                   | 14     | 301      | 2,565    | 13,205   | 61,969   | 144,142  | 333,139  | x         | x         | x         |
| DP Value (usd)                 | 345.28 | 473.25   | 1,360.02 | 2,248.65 | 2,886.51 | 2,820.16 | 3,298.88 | x         | x         | x         |
| DP Weight (current price)      | 336.58 | 872.13   | 1,583.41 | 2,493.08 | 2,497.68 | 2,485.88 | 2,477.08 | x         | x         | x         |
