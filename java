---
syntax: java
tags: [ java, jshell ]
---

// Group items into batches
jshell> var counter = 0
counter ==> 0

jshell> var batchSize = 3
batchSize ==> 3

jshell> var batches = IntStream.range(1, 10 + 1).boxed().collect(Collectors.groupingBy(f -> counter++ / batchSize)).values()
batches ==> [[1, 2], [3, 4, 5], [6, 7, 8], [9, 10]]

// Flatten nested list

jshell> var list = List.of(
   ...> List.of("a", "b", "c"),
   ...> List.of("1", "2"),
   ...> List.of("foo", "bar", "baz")
   ...> )
list ==> [[a, b, c], [1, 2], [foo, bar, baz]]

jshell> var flattened = list.stream().flatMap(Collection::stream).collect(Collectors.toList())
flattened ==> [a, b, c, 1, 2, foo, bar, baz]

// Group list

jshell> var list = List.of(
   ...> List.of("a", "1"),
   ...> List.of("b", "2"),
   ...> List.of("a", "3"),
   ...> List.of("b", "4")
   ...> )
list ==> [[a, 1], [b, 2], [a, 3], [b, 4]]

jshell> var map = list.stream().collect(Collectors.toMap(k -> k.get(0), v -> Arrays.asList(v.get(1)), (v1, v2) -> Stream.concat(v1.stream(), v2.stream()).collect(Collectors.toList())))
map ==> {a=[1, 3], b=[2, 4]}

// java equivalent of "ruby dig"

String phoneNumber = Optional.ofNullable(list.get(0))
                             .map(Order::getCustomer)
                             .map(Customer::getPhone)
                             .orElse(null);

// Primitive array to List

int[] input = new int[]{1,2,3,4};
List<Integer> output = IntStream.of(input).boxed().collect(Collectors.toList());

// Instant Epoch

jshell> Clock.systemUTC().instant()
$8 ==> 2020-11-25T09:00:00.00Z

jshell> Instant.parse("2020-11-25T09:00:00.00Z").getEpochSecond()
$10 ==> 1606294800

jshell> Instant.ofEpochSecond(1606294800)
$11 ==> 2020-11-25T09:00:00Z
|  created scratch variable $11 : Instant
