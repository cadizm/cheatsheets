# Unpack hash value into new hash without key "id"
$ cat segments.json | jq '.segments | map_values(. | map(.id))' > new-segments.json
