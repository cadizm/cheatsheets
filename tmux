# list key bindings
prefix, ?

# choose a session/window/pane
prefix, s

# select next layout
prefix, space

# copy mode
prefix, [

# swap windows
swap-window -t <window num>

# swap panes
ctrl-v, o  # (keep v pressed)

# resize panes
ctrl-v, <arrow key>  # (keep v pressed)


# list window information
tmux list-windows

# split "horizontally"
ctrl-v "

# split "vertically"
ctrl-v %

# kill tmux
tmux kill-session
