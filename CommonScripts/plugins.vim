"--------------Vundle PluginManager--------------"
filetype off          "required for Vundle


" set the runtime path to include Vundle and initialize
set rtp+=C:/Files_For_Windows/.vim/bundle/Vundle.vim
" Include My snippets
set rtp+=C:/Files_For_Windows/.vim


call vundle#begin('C:/Files_For_Windows/.vim/plugins/')
" alternatively, pass a path where Vundle should install plugins
"call vundle#begin('~/some/path/here')

" let Vundle manage Vundle, required
Plugin 'VundleVim/Vundle.vim'

Plugin 'marijnh/tern_for_vim'


"-------------------AutoComplete-------------------"
Plugin 'valloric/youcompleteme'

Plugin 'pangloss/vim-javascript'
Plugin 'mxw/vim-jsx'

Plugin 'fatih/vim-go'

"-------------------ColorScheme-------------------"
Plugin 'altercation/vim-colors-solarized'
Plugin 'dracula/Vim'

"-------------------Tree-------------------"
Plugin 'scrooloose/nerdtree'

" WARNING!!! Next plugin needs to install <ctags>
"-------------------Ctrl-P-------------------"
Plugin 'ctrlpvim/ctrlp.vim'

" WARNING!!! Next plugin needs to install <the_silver_searcher>
"-------------------Ag-------------------"
Plugin 'rking/ag.vim'

"-------------------Replace Strings-------------------"
Plugin 'skwp/greplace.vim'

"-------------------Snippets-------------------"
Plugin 'sirver/ultisnips'
Plugin 'honza/vim-snippets'

"-------------------Add Bracers-------------------"
Plugin 'tpope/vim-surround'

"-------------------MarkDown-------------------"
Plugin 'iamcco/mathjax-support-for-mkdp'
Plugin 'iamcco/markdown-preview.vim'

"-------------------Show Git Diff-------------------"
Plugin 'airblade/vim-gitgutter'

" Keep Plugin commands between vundle#begin/end.

" All of your Plugins must be added before the following line
call vundle#end()            " required
filetype plugin indent on    " required
" To ignore plugin indent changes, instead use:
"filetype plugin on
"
" Brief help
" :PluginList       - lists configured plugins
" :PluginInstall    - installs plugins; append `!` to update or just :PluginUpdate
" :PluginSearch foo - searches for foo; append `!` to refresh local cache
" :PluginClean      - confirms removal of unused plugins; append `!` to auto-approve removal
"
" see :h vundle for more details or wiki for FAQ
" Put your non-Plugin stuff after this line
